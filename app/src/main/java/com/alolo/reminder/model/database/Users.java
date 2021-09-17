package com.alolo.reminder.model.database;

public class Users {
    private String u_Name;
    private String u_pass;
    private int u_idd;
    public Users(String u_Name, String u_pass) {
        this.u_Name = u_Name;
        this.u_pass = u_pass;
    }

    public Users() {

    }

    public Users(String u_Name, String u_pass, int u_idd) {
        this.u_Name = u_Name;
        this.u_pass = u_pass;
        this.u_idd = u_idd;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public int getU_idd() {
        return u_idd;
    }

    public void setU_idd(int u_idd) {
        this.u_idd = u_idd;
    }
}
