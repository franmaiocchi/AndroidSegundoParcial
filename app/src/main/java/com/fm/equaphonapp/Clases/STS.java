package com.fm.equaphonapp.Clases;

public class STS
{
    private String name;
    private int img;

    public STS(String name, int img)
    {
        setName(name);
        setImg(img);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setImg(int img)
    {
        this.img = img;
    }

    public String getName()
    {
        return name;
    }

    public int getImg()
    {
        return img;
    }
}
