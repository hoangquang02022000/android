package model;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private int id;
    private String name;
    private String numberPhone;

    public DanhBa() {
    }

    public DanhBa(int id, String name, String numberPhone) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
