package com.example.peterson.whereiam21;

import java.util.Date;

public class SendData {

    private String search;
    private Integer ra;
    private String date;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "search:" + getSearch()
                + "\nra: "+ getRa()
                + "\ndate: "+getDate();
    }
}
