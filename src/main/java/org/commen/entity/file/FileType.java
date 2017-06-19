package org.commen.entity.file;

/**
 * FileType entity. @author MyEclipse Persistence Tools
 */

public class FileType implements java.io.Serializable
{

    // Fields

    private Integer id;
    private String  name;

    // Constructors

    /** default constructor */
    public FileType()
    {
    }

    public FileType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    /** full constructor */
    public FileType(String name) {
        this.name = name;
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}