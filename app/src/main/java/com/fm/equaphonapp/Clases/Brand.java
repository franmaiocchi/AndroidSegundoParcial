package com.fm.equaphonapp.Clases;

public class Brand
{
    private String name;
    private String description;
    private int image;

    public Brand()
    {
        // Constructor vacio
    }

    public Brand(String name, String description, int image)
    {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getImage()
    {
        return this.image;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setImage(int image)
    {
        this.image = image;
    }
}
