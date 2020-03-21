package com.example.peterson.whereiam21;

import android.content.Intent;

class ScanSignal {
    private String local;
    private int mediaTsi;
    private int mediaC7;
    private int mediaF5;
    private int mediaD0;
    private int mediaF6;
    private int mediaC8;


    public ScanSignal(){

    }

    public ScanSignal(String csvLine){
        String[] tokens = csvLine.split(",");
        local = tokens[0];

        try{
            mediaTsi = Integer.parseInt(tokens[1]);
        }catch(Exception e){
            mediaTsi = -Integer.MAX_VALUE;
        }

        try{
            mediaC7 = Integer.parseInt(tokens[2]);
        }catch(Exception e){
            mediaC7 = -Integer.MAX_VALUE;
        }

        try{
            mediaF5 = Integer.parseInt(tokens[3]);
        }catch(Exception e){
            mediaF5 = -Integer.MAX_VALUE;
        }

        try{
            mediaD0 = Integer.parseInt(tokens[4]);
        }catch(Exception e){
            mediaD0 = -Integer.MAX_VALUE;
        }

        try{
            mediaF6 = Integer.parseInt(tokens[5]);
        }catch(Exception e){
            mediaF6 = -Integer.MAX_VALUE;
        }

        try{
            mediaC8 = Integer.parseInt(tokens[6]);
        }catch(Exception e){
            mediaC8 = -Integer.MAX_VALUE;
        }
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getMediaTsi() {
        return mediaTsi;
    }

    public void setMediaTsi(int mediaTsi) {
        this.mediaTsi = mediaTsi;
    }

    public int getMediaC7() {
        return mediaC7;
    }

    public void setMediaC7(int mediaC7) {
        this.mediaC7 = mediaC7;
    }

    public int getMediaF5() {
        return mediaF5;
    }

    public void setMediaF5(int mediaF5) {
        this.mediaF5 = mediaF5;
    }

    public int getMediaD0() {
        return mediaD0;
    }

    public void setMediaD0(int mediaD0) {
        this.mediaD0 = mediaD0;
    }

    public int getMediaF6() {
        return mediaF6;
    }

    public void setMediaF6(int mediaF6) {
        this.mediaF6 = mediaF6;
    }

    public int getMediaC8() {
        return mediaC8;
    }

    public void setMediaC8(int mediaC8) {
        this.mediaC8 = mediaC8;
    }

    public String toString(){
        return (local+","+mediaTsi+","+mediaC7+","+mediaF5+","+mediaD0+","+mediaF6+","+mediaC8);
    }
}