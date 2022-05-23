package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.security.DrbgParameters;


public class Main {
    static void Task1( Scanner num,DecimalFormat f)
    {
        float b, c;
        while (true) {
            System.out.println("Введіть значення b  (b>0): ");
            b = num.nextFloat();
            if(b>0)
                break;
            else
                System.out.println("Невірне значення!!! ");
        }
        while (true) {
            System.out.println("Введіть значення C (-5, 0, 5): ");
            c = num.nextFloat();
            if (c == 5) {
                System.out.println("Значення функції = " + f.format(Math.sqrt(b)+(2*Math.sqrt(c))));
                break;
            }
             else if(c==0)
            {
                System.out.println("Значення функції = " + (b/(c+6)));
                break;
            }
            else if(c==-5)
            {
                System.out.println("Значення функції = " + (b+(12+Math.pow(c,3))));
                break;
            }
            else
                System.out.println("Невірне значення!!! ");
           /* if (c == 5) {
                System.out.println("Значення функції = " + f.format(Math.sqrt(b)+(2*Math.sqrt(c))));
                break;
            }
             if(c==0)
            {
                System.out.println("Значення функції = " + (b/(c+6)));
                break;
            }
             if(c==-5)
            {
                System.out.println("Значення функції = " + (b+(12+Math.pow(c,3))));
                break;
            }
            else
                System.out.println("Невірне значення!!! ");*/
        }
    }
    static  void Task2(Scanner num)
    {
        float A,B,C;
        System.out.println("Введіть число A: ");
        A=num.nextFloat();
        System.out.println("Введіть число B: ");
        B=num.nextFloat();
        System.out.println("Введіть число C: ");
        C=num.nextFloat();
        if(A<B && B<C)
        {
            System.out.println("Подвоєння чисел: ");
            System.out.print("A= "+Math.round(A*2)); System.out.print("  B= "+Math.round(B*2));System.out.print("  C= "+Math.round(C*2));
        }else
        {
            System.out.print("A= "+A*-1); System.out.print("  B= "+B*-1);System.out.print("  C= "+C*-1);
            System.out.println("\n");
        }

    }
    static void Task3(Scanner num)
    {
        System.out.println("Введіть номер місяця: ");
        byte n=num.nextByte();
        switch(n)
        {
            case 1:
                System.out.println("Cічень");
                break;
            case 2:
                System.out.println("Лютий");
                break;
            case 3:
                System.out.println("Березень");
                break;
            case 4:
                System.out.println("Квітень");
            break;
            case 5:
                System.out.println("Травень");
                break;
            case 6:
                System.out.println("Червень");
                break;
            case 7:
                System.out.println("Липень");
                break;
            case 8:
                System.out.println("Серпень");
                break;
            case 9:
                System.out.println("Вересень");
                break;
            case 10:
                System.out.println("Жовтень");
                break;
            case 11:
                System.out.println("Листопад");
                break;
            case 12:
                System.out.println("Грудень");
                break;
            default:
                System.out.println("Такого місяця немає! ");
                break;
            //.........:(((
        }
    }
    static void Task4(Scanner num,DecimalFormat f)
    {
        double x=0,y=0,z=0,a1=0,a2=0;

            try {
                System.out.println("Введіть x: ");
                x = num.nextFloat();
                System.out.println("Введіть y: ");
                y = num.nextFloat();
                System.out.println("Введіть z: ");
                z = num.nextFloat();
            }
            catch (Exception ex)
            {
                System.out.println("Не коректне введення");

                Task4(new Scanner(System.in),f);
                return;
            }

        try {
            a1 = Math.pow(x, 2) * y - z;
            a2 = x + y + z;
            if (a1 <= 0 || a2<=0) {
                throw new ArithmeticException("Виникла проблема!");
            } else
                System.out.println("Функція = " + f.format((Math.sqrt(a1) + Math.log(a2))));
        }catch(ArithmeticException e) {
            System.out.println("Число <=0 під коренем або логорифмом ");
        }
    }

    public static void main(String[] args)
    {
    Scanner num=new Scanner(System.in);
    byte taskNumber;
    boolean run= true;
    while (run)
    {
        System.out.println("Введіть номер завдання!(1-4;5-ВИХІД): ");
        taskNumber=num.nextByte();
        DecimalFormat f = new DecimalFormat("##.00");
        switch (taskNumber)
        {
            case 1:
                System.out.println("Завдання 1: ");
                Task1(num,f);
                break;
            case 2:
                System.out.println("Завдання 2: ");
                Task2(num);
                break;
            case 3:
                System.out.println("Завдання 3: ");
                Task3(num);
                break;
            case 4:
                System.out.println("Завдання 4: ");
                Task4(num,f);
                break;
            case 5:
                System.out.println("Завершення програми");
                 return;
            default:
                System.out.println("?");
                break;
        }
    }
    }
}
