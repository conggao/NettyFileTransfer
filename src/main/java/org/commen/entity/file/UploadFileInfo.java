package org.commen.entity.file;

import java.sql.Timestamp;

/**
 * UploadFileInfo entity. @author MyEclipse Persistence Tools
 */

public class UploadFileInfo implements java.io.Serializable
{

    // Fields

    private Long      id;
    private String    name;
    private Integer   playTime;
    private String    path;
    private Long      size;
    private String    ext;
    private Long      userId;
    private Boolean   isdel;
    private Integer   serverId;
    private Timestamp time;

    // Constructors

    /** default constructor */
    public UploadFileInfo()
    {
    }

    /** minimal constructor */
    public UploadFileInfo(String name, String path, Long size, Boolean isdel, Timestamp time)
    {
        this.name = name;
        this.path = path;
        this.size = size;
        this.isdel = isdel;
        this.time = time;
    }

    /** full constructor */
    public UploadFileInfo(String name, Integer playTime, String path, Long size, String ext, Long userId, Boolean isdel, Integer serverId, Timestamp time)
    {
        this.name = name;
        this.playTime = playTime;
        this.path = path;
        this.size = size;
        this.ext = ext;
        this.userId = userId;
        this.isdel = isdel;
        this.serverId = serverId;
        this.time = time;
    }

    // Property accessors

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getPlayTime()
    {
        return this.playTime;
    }

    public void setPlayTime(Integer playTime)
    {
        this.playTime = playTime;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public Long getSize()
    {
        return this.size;
    }

    public void setSize(Long size)
    {
        this.size = size;
    }

    public String getExt()
    {
        return this.ext;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }

    public Long getUserId()
    {
        return this.userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Boolean getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(Boolean isdel)
    {
        this.isdel = isdel;
    }

    public Integer getServerId()
    {
        return this.serverId;
    }

    public void setServerId(Integer serverId)
    {
        this.serverId = serverId;
    }

    public Timestamp getTime()
    {
        return this.time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

}