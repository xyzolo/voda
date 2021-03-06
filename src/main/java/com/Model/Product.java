package com.Model;

public class Product {
    private String name;
    private float vp;
    private float summ;

    public Product(String name, float vp, float summ) {
        this.name = name;
        this.vp = vp;
        this.summ = summ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVp() {
        return vp;
    }

    public void setVp(float vp) {
        this.vp = vp;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", vp=" + vp +
                ", summ=" + summ +
                '}';
    }
}
