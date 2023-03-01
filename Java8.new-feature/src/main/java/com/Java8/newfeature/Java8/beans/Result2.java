package com.Java8.newfeature.Java8.beans;

public class Result2 {
	private String name;
    private String timestamp;
 
    public Result2(String name, String timestamp) {
        
        this.name = name;
        this.timestamp = timestamp;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
 
    @Override
    public String toString() {
        return "Result [name=" + name + ", value=" + timestamp + "]";
    }
}