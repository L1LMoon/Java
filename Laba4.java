package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static void InputArr(int[][] arr,int n,int m)
    {
        for(int i=0;i<n;i++)
        {
            System.out.println("Рядок№ "+ (i+1));
            for(int j=0;j<m;j++) {
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }
    }
    static void Task1(Scanner num) {
        byte n;
        byte m;
        boolean a;
do {
    System.out.println("Висота матриці: ");
     n = new Scanner(System.in).nextByte();
    System.out.println("Ширина матриці: ");
     m = new Scanner(System.in).nextByte();
     a =false;
    if(n<=0||m<=0)
    {
        System.out.println("Некоректне введення!!");
        a=true;
    }
}while(a!=false);

        int[][]A =new int[n][m];
        InputArr(A,n,m);
        System.out.println("Рядки з нульовими елементами: ");
        boolean key=true;
        for(int i=0;i<n;i++)
        {
            for (int j = 0;j < m; j++)
            {
                if (A[i][j] == 0)
                {
                    key=false;
                    System.out.println("\nНомер рядка: ");
                    System.out.println(i);
                    System.out.println("Рядок: ");
                    for(int k=0;k<m;k++)
                    {
                        System.out.print(A[i][k]+" ");
                    }
                    break;
                }
            }
        }
        if(key)
        {
            System.out.println("Відсутні!");
        }
    }

    static void Task2(Scanner num)
    {
        Random rnd = new Random(System.currentTimeMillis());
        int min = -100;
        int max = 100;
        System.out.println("Введіть розмір квадратної матриці(>0):");
        int size= num.nextByte();
        while(size<0||size==0)
        {
            System.out.println("недопустиме значення...Введіть щераз: ");
            size= num.nextByte();
        }
        int[][] A=new int[size][size];

        System.out.println("Заповнення матриці випадковими числами.....");

        for(int i=0;i<size;i++)
            for (int j=0;j<size;j++)
                A[i][j] = min + rnd.nextInt(max - min + 1);
        System.out.println("Вивід матриці: ");
        for(int i=0;i<size;i++)
        {
            for (int j = 0; j < size; j++)
                System.out.print("\t\t"+A[i][j]);
            System.out.println("\n");
        }


        System.out.println("Введіть першу межу інтервалу: ");
        int a=num.nextInt();
        System.out.println("Введіть другу межу інтервалу: ");
        int b=num.nextInt();
        while(b<=a)
        {
            System.out.println("Введіть щераз(b<=a)");
            b=num.nextInt();
        }
        Vector<Integer> v=new Vector<Integer>();
        for(int i=0;i<size;i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(A[i][j]>=a&&A[i][j]<=b)
                    v.add(A[i][j]);
            }
        }
        System.out.println("Вивід елементів які добвленні в вектор на проміжку:");
        for (Integer i:v)
        {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        boolean run=true;
        byte number;
        Scanner num=new Scanner(System.in);

        while(run) {
            System.out.println("\nВибертіть номер завдання (1-2, 5-ВИХІД!): ");
            number = num.nextByte();
            switch (number) {
                case 1:
                    System.out.println("Завдання 1: ");
                    Task1(num);
                    break;
                case 2:
                    Task2(num);
                    break;
                case 5:
                    System.out.println("Завершення виконання....");
                    run=false;
                    break;
                default:
                    System.out.println("Введіть щераз: ");
                    number=num.nextByte();
                    break;
            }
        }
    }
}
