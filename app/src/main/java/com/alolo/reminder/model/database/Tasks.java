package com.alolo.reminder.model.database;

public class Tasks {
    private String t_Name;
    private String dead;
    private int t_ide;
    public Tasks() {

    }
    public Tasks(String t_Name, String dead) {
        this.t_Name = t_Name;
        this.dead = dead;
    }

    public Tasks(String t_Name, String dead, int t_ide) {
        this.t_Name = t_Name;
        this.dead = dead;
        this.t_ide = t_ide;
    }

    public int getT_ide() {
        return t_ide;
    }

    public void setT_ide(int t_ide) {
        this.t_ide = t_ide;
    }

    public String getT_Name() {
        return t_Name;
    }

    public void setT_Name(String t_Name) {
        this.t_Name = t_Name;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }
}

