package org.server.dao;

import java.util.List;

import org.commen.entity.file.FileServerInfo;
import org.commen.entity.file.UploadFileInfo;
import org.commen.entity.file.ViewUploadFileInfo;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FileDAOImpl extends HibernateDaoSupport implements FileDAO
{

    @Override
    public UploadFileInfo queryUploadFileInfo(Long id)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            List<UploadFileInfo> list = (List<UploadFileInfo>) ht.find(String.format("from UploadFileInfo where id = '%d' and isdel = 0", id));
            if (list != null && list.size() > 0)
            {
                return list.get(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUploadFileInfo(UploadFileInfo info)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            ht.saveOrUpdate(info);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUploadFileInfo(List<UploadFileInfo> list)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            ht.save(list);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delUploadFileInfo(Long id)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            List<UploadFileInfo> list = (List<UploadFileInfo>) ht.find(String.format("from UploadFileInfo where id = %d", id));
            if (list != null && list.size() == 1)
            {
                UploadFileInfo info = list.get(0);
                if (info != null)
                {
                    info.setIsdel(true);
                    ht.update(info);
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public FileServerInfo queryFileServerInfoById(Integer id)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            List<FileServerInfo> list = (List<FileServerInfo>) ht.find("from FileServerInfo where id=?", id);
            if (null != list && list.size() == 1)
            {
                return list.get(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateFileServerInfo(FileServerInfo info)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            ht.saveOrUpdate(info);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ViewUploadFileInfo queryViewUploadFileInfo(Long id)
    {
        try
        {
            HibernateTemplate ht = this.getHibernateTemplate();
            List<ViewUploadFileInfo> list = (List<ViewUploadFileInfo>) ht.find(String.format("from ViewUploadFileInfo where id = '%d'", id));
            if (list != null && list.size() > 0)
            {
                return list.get(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    private String formatQueryDirReqCondition(Long id, String condition, Long createUserId, Integer createSchoolId)
    {
        String where = "";
        if (null != id)
        {
            where += String.format(" and parentId = '%d'", id);
        }
        if (null != condition && condition != "")
        {
            where += String.format(" and name like '%%%s%%'", condition);
        }
        if (null != createUserId)
        {
            where += String.format(" and createUserId = '%d'", createUserId);

        }
        if (null != createSchoolId)
        {
            where += String.format("and createSchoolId = '%d'", createSchoolId);
        }

        return where;
    }



}
