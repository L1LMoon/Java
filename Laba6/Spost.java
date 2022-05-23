package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Spost {
    private Date date;
    private int tempAir;
    private int tisk;
    Spost(Date date, int tempAir, int tisk)
    {
        this.date=date;
        this.tempAir=tempAir;
        this.tisk=tisk;
    }
    Spost()
    {
        this.date=null;
        this.tempAir=0;
        this.tisk=0;
    }
    public void Output()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Дата: "+dateFormat.format(date)+"\t|Температура повітря: "+ tempAir+"\t|Тиск: "+ tisk);
        System.out.println("--------------------------------------------------------------------------");
    }
    public void Input()
    {

        System.out.println("Дата = ");
        System.out.println("Температура повітря = "); tempAir=new Scanner(System.in).nextInt();
        System.out.print("Тиск = "); tisk=new Scanner(System.in).nextInt();
    }
    public int getTisk()
    {
        return tisk;
    }

    public boolean ChekTisk(float serTisk)
    {
        if(tisk>serTisk)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
