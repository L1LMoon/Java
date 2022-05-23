package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {
    
    static void InputArr( int []arr,Scanner num)
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=num.nextInt();
        }
    }
    static void OutputArr( int[] arr)
    {
        for (int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+"  ");
        }
    }
    static int minusCount(int[] arr)
    {
        int count=0;
        for (int i =0;i<arr.length; i++)
              {
            if(arr[i]<0)
                count++;
        }
        return  count;
    }
    static void Task1(Scanner num)
    {
        byte size;
        do {
            System.out.println("Введіть розмір массива(>0): ");
            size = num.nextByte();
        }while(size<0);

        int[] arr=new int[size];
        boolean key=false;
        System.out.println("Введення массива: ");
        InputArr(arr, num);

            for (int i = 1; i < size; i++) {
               if (Math.signum(arr[i])!=Math.signum(arr[i-1])){
                    key = true;
                } else {
                   key = false;
                   break;
               }
            }


            if (key) {
                System.out.println("Елементи чередуються:");
                OutputArr(arr);
            } else
            {
                int minusSize=minusCount(arr);
                int[] minus=new int[minusSize];
                int j=0;
                for(int i=0;i<arr.length;i++)
                {
                    if(arr[i]<0)
                    {
                        minus[j]=arr[i];
                        j++;
                    }

                }
                System.out.println("Елементи не чередуються: ");
                System.out.println("Вивід масиву відємних елементів: ");
                OutputArr(minus);
            }

    }
    static int NullCount(int[] arr)
    {
        int count=0;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==0)
                count++;
        }
        return count;
    }
    static int Bruh(int[]arr)
    {
        int dobut=1;
        int maxIndex=0;
        int max=arr[0];
        //Визначаєм індекс максимального елемента за модулем
        for (int i=0;i<arr.length;i++)
        {
            if(Math.abs(arr[i])>Math.abs(max)) {
                max=arr[i];
                maxIndex = i;
            }
        }

        for (int i=maxIndex+1;i< arr.length;i++)
        {
            dobut=dobut*arr[i];
        }

        return dobut;
    }

    static void Task2(Scanner num)
    {
        byte number;
        byte size;
        do {
            System.out.println("Введіть розмір массива(>0): ");
            size = num.nextByte();
        }while(size<0);
        int[] arr = new int[size];
        System.out.println("Ввести массив :\n1. З клавіатури:\n2. Випадковими числами[-100;100]");
        number=num.nextByte();

        switch (number) {
            case 2:
            Random rnd = new Random(System.currentTimeMillis());
            int min = -100;
            int max = 100;
            for (int i = 0; i < size; i++) {
                arr[i] = min + rnd.nextInt(max - min + 1);
            }
            break;
            case 1:
                System.out.println("Введення з клавіатури: ");
                InputArr(arr,num);
                break;
            default:
                System.out.println("Невірне значення!");
                break;
        }
        OutputArr(arr);
        System.out.println("Кількість нульвих елементів: "+NullCount(arr));
        System.out.println("Добуток  елементів  масиву, розташованих після максимального елемента за модулем: "+Bruh(arr));

    }

    
    public static void main(String[] args)
    {
        Scanner num=new Scanner(System.in);
        boolean run=true;
	    byte number;
        while(run) {
            System.out.println("Вибертіть номер завдання (1-2, 5-ВИХІД!): ");
            number = num.nextByte();
            switch (number) {
                case 1:
                    System.out.println("Завдання 1: ");
                    Task1(num);
                    break;
                case 2:
                    System.out.println("Завдання 2: ");
                    Task2(num);
                    break;
                case 5:
                    System.out.println("Завершення виконання....");
                    run=false;
                    break;
                default:
                    System.out.println("Не вірне значення:");
                    break;
            }
        }
    }
}
