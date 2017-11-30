/*
 * Created by Osman Balci on 2017.11.30  * 
 * Copyright © 2017 Justin Hoelscher. All rights reserved. * 
 */
package com.mycompany.APIInteraction;

/**
 *
 * @author Justin
 */
public class BaseRate {
    private String characteristic;
    private String race;
    private String sex;
    private int year;
    private int count;
    private double percentage;
    
    public BaseRate(String characteristic, int count, double percentage, String race, String sex, int year) {
        this.characteristic = characteristic;
        this.count = count;
        this.percentage = percentage;
        this.race = race;
        this.sex = sex;
        this.year = year;
    }
    
    

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
