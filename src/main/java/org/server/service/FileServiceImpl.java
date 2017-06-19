package org.server.service;

import org.commen.entity.file.UploadFileInfo;
import org.commen.util.BasicUtils;
import org.commen.util.FileMgtUtils;
import org.commen.util.ImageUtils;
import org.commen.util.defs.CommDefs;
import org.server.dao.FileDAO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.commons.io.FileUtils.copyFile;

/**
 * Created by pc on 2017/6/19.
 */
public class FileServiceImpl {
    FileDAO fileDAO;
    //保存文件到服务器和生成路径
    public boolean dispatchUpload(List<UploadFileInfo> listFileInfo,List<File> listFile, String moduleName,String userName,Long userId, Integer playTime)
    {
        try
        {

            if (moduleName == null || moduleName.equals(""))
            {
                moduleName = "unknown";
            }
            String root = getDiskRootPath(moduleName,userName);
            String path = BasicUtils.createDateDirTree(root);

            for (int i = 0; i < listFileInfo.size(); i++)
            {
                InputStream is;
                File file = listFile.get(i);
                if (file == null)
                {
                    return false;
                }
                if (file.length() <= 0)
                {
                    return false;
                }

                String strTime = BasicUtils.getCurrentAccurateDateTimeString();
                String fileName = String.format("%s%02d_%s", strTime, i + 1, listFile.get(i).getName());
                String fullName = root + "/" + path + "/" + fileName;
                String extName = FileMgtUtils.getFileSuffix(fileName);

                File oldFile = listFile.get(i);
                File newFile = new File(fullName);
                copyFile(oldFile, newFile);
                /*
                 * if (null != ImageUtils.thumbnailImage(fullName,
                 * CommDefs.THUMB_PIC_SIZE_SMALL)) { if (null !=
                 * ImageUtils.thumbnailImage(fullName,
                 * CommDefs.THUMB_PIC_SIZE_MEDIUM)) {
                 */
                Byte scaleType = 1;
                if (null != ImageUtils.thumbnailImage(fullName, CommDefs.THUMB_PIC_SIZE_LARGE, scaleType))
                {
                }
                /*
                 * } }
                 */

                long fileSize = 0;
                File f = new File(root + path, fileName);
                if (f.exists() && f.isFile())
                {
                    fileSize = f.length();
                }
                else
                {
                    return false;
                }
                UploadFileInfo uploadFileInfo = new UploadFileInfo();
                uploadFileInfo.setName(listFile.get(i).getName());
                uploadFileInfo.setPath(getRelativeRootPath(moduleName, userName) + "/" + path + "/" + fileName);
                uploadFileInfo.setUserId(userId);
                uploadFileInfo.setSize(fileSize);
                uploadFileInfo.setIsdel(false);
                uploadFileInfo.setTime(BasicUtils.getCurrentTime());
                uploadFileInfo.setExt(extName);
                uploadFileInfo.setServerId(11);
                uploadFileInfo.setPlayTime(playTime);
                listFileInfo.add(uploadFileInfo);
            }

            if (null != listFileInfo && listFileInfo.size() > 0)
            {
                fileDAO.updateUploadFileInfo(listFileInfo);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    public String getDiskRootPath(String moduleName, String userName)
    {
        File file = new File("");
        String root = file.getAbsolutePath()+"/" + getRelativeRootPath(moduleName, userName);
        return root;
    }
    public String getRelativeRootPath(String moduleName, String userName)
    {
        String root = "/upload" + "/" + moduleName + "/" + userName;
        return root;
    }
}
