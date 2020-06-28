package com.example.mad_assignment3_kalsoomasghar;

public class ModelClass {
    private String image;
    private String name;
    private String email;
    private String number;


    public ModelClass(String image, String name, String email, String number) {
        this.image = image;
        this.name = name;
        this.email=email;
       this.number=number;

    }

    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getNumber() {
        return number;
    }


}
