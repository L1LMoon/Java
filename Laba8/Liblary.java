package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

class Liblary implements Serializable {
    protected String name;
    protected String adress;

}

class Day extends Liblary implements Serializable, Days_Interface
{
    private Date date;
    private int countBookV;
    private int countBookP;

    public Day() {
    }


    public Date getDate() {
        return date;
    }

    public int getCountBookV() {
        return countBookV;
    }

    public int getCountBookP() {
        return countBookP;
    }

    public Day(String name, String adress, Date date, int countBookV, int countBookP) {
        this.name=name;
        this.adress=adress;
        this.date = date;
        this.countBookV = countBookV;
        this.countBookP = countBookP;
    }
    public void Output()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.printf("%-5s %-30s %-5s %-30s %-5s %-30s %-5s %-30d %-5s %-30d","Назва: ",name,"|Адрес: ", adress,"|Дата: ",dateFormat.format(date),"Видано книг: ",countBookV,"Книг повернуто: ", countBookP);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
