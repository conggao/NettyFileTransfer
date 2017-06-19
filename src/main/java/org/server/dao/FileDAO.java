package org.server.dao;

import org.commen.entity.file.FileServerInfo;
import org.commen.entity.file.UploadFileInfo;
import org.commen.entity.file.ViewUploadFileInfo;

import java.util.List;


public interface FileDAO
{

    UploadFileInfo queryUploadFileInfo(Long id);

    boolean updateUploadFileInfo(UploadFileInfo info);

    boolean updateUploadFileInfo(List<UploadFileInfo> list);

    boolean delUploadFileInfo(Long id);

    FileServerInfo queryFileServerInfoById(Integer id);

    boolean updateFileServerInfo(FileServerInfo info);

    ViewUploadFileInfo queryViewUploadFileInfo(Long id);

}
