package org.commen.entity.file;

import java.sql.Timestamp;

/**
 * FileServerInfo entity. @author MyEclipse Persistence Tools
 */

public class FileServerInfo implements java.io.Serializable
{

    // Fields

    private Integer   id;
    private String    serverUrl;
    private Timestamp time;

    // Constructors

    /** default constructor */
    public FileServerInfo()
    {
    }

    /** full constructor */
    public FileServerInfo(String serverUrl, Timestamp time)
    {
        this.serverUrl = serverUrl;
        this.time = time;
    }

    // Property accessors

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getServerUrl()
    {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl)
    {
        this.serverUrl = serverUrl;
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