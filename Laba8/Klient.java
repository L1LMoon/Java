package com.company;

import java.io.Serializable;
import java.util.Date;

public class Klient implements Klient_Interface, Serializable {
    private int number;
    private String full_name;
    private int sum;

    private int count_operation;

    public Klient() {
    }

    public int getCount_operation() {
        return count_operation;
    }

    public Klient(int number,String full_name,int sum,int count_operation)
    {
        this.number=number;
        this.full_name=full_name;
        this.sum=sum;
        this.count_operation=count_operation;
    }


    public void Output()
    {
        System.out.printf("%-5s %-5d %-5s %-5s %-5s %-5d %-5s %-5d","Номер рахунку: ",number,"|Прізвище ім'я ", full_name,"|Сума вкладу:",sum,"Кількість операцій: ",count_operation);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
