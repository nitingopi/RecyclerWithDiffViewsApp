package com.example.test.recyclerwithdiffviewsapp;

/**
 * Created by test on 28/2/17.
 */
public class User {

    private String name;
    private String region;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String name, String region, String type){
        setName(name);
        setRegion(region);
        setType(type);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
