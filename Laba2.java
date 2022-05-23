package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

   static void Task1(Scanner num, DecimalFormat fo)
    {
        int x, y;
        double znam, f;
       while(true)
       {
           System.out.println("Введіть цілі числа: \n\tX= "); x=num.nextInt();System.out.println("\tY= "); y=num.nextInt();
           znam=1+Math.pow(x,2)+Math.pow(y,2); //Знаменник ; pow-Піднесення до степення
           if(znam==0)
               System.out.println("Відбувається ділення на 0! Введіть значення повторно.");
           else
               break;
       }
        f= (  Math.pow(x,2)+(x*y)-Math.pow(y,2)  )/znam;
        System.out.println("Результат функції: "+ fo.format(f));

    }
   static int For()
    {
        int sum=0;
        //Цикл з параметром
        for(byte i=1;i<=100;i++)
        {
            if(i%5==0)
                sum=sum+i;
        }
        return sum;
    }
    static  int DoWhile()
    {
        int sum=0;
        int i=1;
        do {
            if(i%5==0)
                sum=sum+i;
            i++;
        }while(i<=100);
        return sum;
    }
    static int eWhile()
    {
        int sum=0;
        int i=1;
        while(i<=100)
        {
            if (i % 5 == 0) {
                sum = sum + i;
            }
            i++;
        }
        return sum;
    }
    static double Task3(Scanner num,int n,float x)
    {

        double sum=0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<5;j++)
            {
                double a=(x+(2*i))/j;
                sum=sum+a;
            }
        }
        return sum;
    }
   static void Task4(DecimalFormat f)
    {
        int a=0;
        double pi=3.14;
        double b=pi;
        double dx=pi/20;
        for(double x=a;x<=b;x=x+dx)
        {
            double n=(Math.tan(x)+13);
            double y=((Math.pow(n,1.0/4.0)));
            System.out.println("X= "+f.format(x)+"\t\t\t\t Y= "+f.format(y));
        }
    }

    public static void main(String[] args) {
        boolean program=true;
        byte taskNumber;
        DecimalFormat f = new DecimalFormat("##.##");
        Scanner number= new Scanner(System.in);
        while(program)
        {
            System.out.println("Введіть номер завдання(1-4; 5-вихід): ");
            taskNumber=number.nextByte();
            switch(taskNumber)
            {
                case 1:
                    System.out.println("Завдання 1: ");
                    Task1(number,f);
                    break;
                case 2:
                    System.out.println("Завдання 2: ");
                    System.out.println("Сума всіх чисел, кратних 5, у діапазоні (1;100]: ");
                    System.out.println("Цикл з параметром: "+For()+"\nЦикл з передумовою: "+DoWhile()+"\nЦикл з після умовою: "+eWhile());
                    break;
                case 3:
                    System.out.println("Завдання 3: ");
                    System.out.println("Введіть натуральне чилсло n="); int n= number.nextInt();
                    while(n<0)
                    {
                        System.out.println("Недопустиме значення!! \nВведіть щераз: ");
                        n=number.nextInt();
                    }
                    System.out.println("Введіть ціле чилсло x="); float x=number.nextFloat();
                    System.out.println("Сума: "+f.format(Task3(number,n,x)));
                    break;
                case 4:
                    System.out.println("Завдання 4: ");
                    Task4(f);
                    break;
                case 5:
                    System.out.println("Завершення програми ");
                    program=false;
                    break;
                default:
                    System.out.println("Невірне значення! ");
                    break;
            }

        }
    }
}
