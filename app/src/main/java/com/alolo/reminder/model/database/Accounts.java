package com.alolo.reminder.model.database;

public class Accounts {
    private String a_Name;
    private String a_pass;
    private int a_id;
    public Accounts() {

    }
    public Accounts(String a_Name, String a_pass) {
        this.a_Name = a_Name;
        this.a_pass = a_pass;
    }

    public Accounts(String a_Name, String a_pass, int a_id) {
        this.a_Name = a_Name;
        this.a_pass = a_pass;
        this.a_id = a_id;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_Name() {
        return a_Name;
    }

    public void setA_Name(String a_Name) {
        this.a_Name = a_Name;
    }

    public String getA_pass() {
        return a_pass;
    }

    public void setA_pass(String a_pass) {
        this.a_pass = a_pass;
    }
}

