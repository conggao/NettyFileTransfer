package org.commen.entity.file;

/**
 * ViewUploadFileInfo entity. @author MyEclipse Persistence Tools
 */

public class ViewUploadFileInfo implements java.io.Serializable
{

    // Fields

    private Long    id;
    private String  name;
    private Long    size;
    private String  ext;
    private String  path;
    private String  url;
    private Integer playTime;

    // Constructors

    /** default constructor */
    public ViewUploadFileInfo()
    {
    }

    /** minimal constructor */
    public ViewUploadFileInfo(Long id, String name, Long size, String path)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.path = path;
    }

    /** full constructor */
    public ViewUploadFileInfo(Long id, String name, Long size, String ext, String path, String url, Integer playTime)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.ext = ext;
        this.path = path;
        this.url = url;
        this.playTime = playTime;
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

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getPlayTime()
    {
        return this.playTime;
    }

    public void setPlayTime(Integer playTime)
    {
        this.playTime = playTime;
    }

}