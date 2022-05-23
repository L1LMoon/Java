package com.company;

import java.io.Serializable;

public class User implements Serializable {
    private String surName;
    private String login;
    private boolean typeLogin;//true = admin; false= user!

    User(String surName, String login, boolean typeLogin) {
        this.surName = surName;
        this.login = login;
        this.typeLogin = typeLogin;
    }

    User() {
        this.surName = "0";
        this.login = "0";
        this.typeLogin = false;
    }

    public String getSurName() {
        return surName;
    }

    public String getLogin() {
        return login;
    }

    public boolean getTypeLogin() {
        return typeLogin;
    }

    public void setSurName(String surName){this.surName=surName;}
    public void setLogin(String login){this.login=login;}
    public  void setTypeLogin(boolean typeLogin){this.typeLogin=typeLogin;}

    public void Output()
    {
        System.out.printf("%-5s %-20s %-5s %-30s %-5s","Прізвище:",surName,"|Обліковий запис: ", login,"|Тип облікового запису: ");
        if(typeLogin)
            System.out.printf("адміністратор: ");
        else
            System.out.printf("корисутвач");
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
