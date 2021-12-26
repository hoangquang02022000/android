package model;

import java.io.Serializable;

public class Nation implements Serializable {
    private int img;
    private String name_Nation;
    private long number_Person;

    public Nation() {
    }

    public Nation(int img, String name_Nation, long number_Person) {
        this.img = img;
        this.name_Nation = name_Nation;
        this.number_Person = number_Person;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName_Nation() {
        return name_Nation;
    }

    public void setName_Nation(String name_Nation) {
        this.name_Nation = name_Nation;
    }

    public long getNumber_Person() {
        return number_Person;
    }

    public void setNumber_Person(long number_Person) {
        this.number_Person = number_Person;
    }
}
