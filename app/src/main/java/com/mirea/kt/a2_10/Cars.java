package com.mirea.kt.a2_10;

public class Cars {
    private String model, number;
    private int age;

    public Cars(String model, String number, int age) {
        this.model = model;
        this.number = number;
        this.age = age;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
