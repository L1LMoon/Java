package com.company;

import java.io.Serializable;

public class Hour extends Kiosk implements Serializable {
    private int countPokup;
    private String comentar;

    Hour(String name, String adress, int countPokup, String comentar)
    {
        this.name=name;
        this.adress=adress;
        this.countPokup=countPokup;
        this.comentar=comentar;
    }

    public int getCountPokup()
    {
        return countPokup;
    }
    @Override
    void Output()
    {
        System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5d %-5s %-5s","Назва: :",name,"|Адреса: ", adress,"|Кількість покупок: ",countPokup,"Коментар: ",comentar,"\n");
        System.out.println("\n--------------------------------------------------------------------------------------");
    }

    @Override
    boolean SComent(String serch)
    {
        if(comentar.equals(serch))
            return true;
      return false;
    }
}
