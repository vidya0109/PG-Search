package com.example.pgsearch.JavaModels;

public class PreviousBookingsInfo {

    String name , previous ;

    public PreviousBookingsInfo(String name, String previous) {
        this.name = name;
        this.previous = previous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
