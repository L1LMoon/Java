package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

   static void RandArray(int[] arr)
    {
        Random rnd = new Random(System.currentTimeMillis());
        int min = -100;
        int max = 100;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + rnd.nextInt(max - min + 1);
        }
    }
    static void OutputArr(int[] arr)
    {
        for (int a: arr) {
            System.out.print(a +" ");
        }
        System.out.println("");
    }
    static int CountElement(int[] arr )
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<7)
            {
                count++;
            }
        }
        return count;
    }
    static int SumElement(int[] arr)
    {
        int firstElementIndex=0, lastElementIndex=0;
        int sum=0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                firstElementIndex=i;
                break;
            }
        }
        for(int i=firstElementIndex+1;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                lastElementIndex=i;
            }
        }
        for(int i=firstElementIndex;i<=lastElementIndex;i++)
        {
            sum=sum+arr[i];
        }
        return sum;
    }
   static void Task1()
    {
        int size;
        do {
            System.out.println("Введіть розмір массива(>0): ");
          size =new Scanner(System.in).nextInt();
        }while(size<0);

        int[] arr=new int[size];
        RandArray(arr);
        OutputArr(arr);
        System.out.println("Кількість елементів < 7: "+ CountElement(arr));
        System.out.println("Суму елементів масиву, розташованих між першим й останнім додатними елементами: "+SumElement(arr));
    }


    static void ChengElement(int [] arr) {
        int maxElementIndex = 0, minElementIndex = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i]>arr[maxElementIndex])
                maxElementIndex=i;
        }
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i]<arr[minElementIndex])
                minElementIndex=i;
        }
        int temp1;
        temp1 = arr[minElementIndex];
        arr[minElementIndex] = arr[maxElementIndex];
        arr[maxElementIndex] = temp1;
    }
    static void Task2()
    {
        int size;
        do {
            System.out.println("Введіть розмір массива(>0): ");
            size =new Scanner(System.in).nextInt();
        }while(size<0);
        int []arr=new int[size];
        RandArray(arr);
        OutputArr(arr);
        ChengElement(arr);
        OutputArr(arr);
    }
    public static void main(String[] args) {
        Scanner num=new Scanner(System.in);
        boolean run=true;
        byte number;
        while(run) {
            System.out.println("Вибертіть номер завдання (1-2, 5-ВИХІД!): ");
            number = num.nextByte();
            switch (number) {
                case 1:
                    System.out.println("Завдання 1: ");
                    Task1();
                    break;
                case 2:
                    System.out.println("Завдання 2: ");
                    Task2();
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
