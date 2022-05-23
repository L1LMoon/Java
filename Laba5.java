package com.company;
import org.w3c.dom.DOMStringList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void Task1() {
        String str;
                System.out.println("Введіть рядок: ");
                str = new Scanner(System.in).nextLine();
                if(str.isEmpty())
                {
                    System.out.println("Рядок пустий!!!!!!!");
                }


        String sentences[] = str.split("[.?!]\\s*");

        final String words[][] = new String[sentences.length][];

        for (int i = 0; i < sentences.length; ++i) {
            words[i] = sentences[i].split("[\\p{Punct}\\s]+");
            System.out.println("Речення: "+ (i+1) +"\tКількість слів: "+words[i].length);
        }
        System.out.println("Найдовше речення");
        int maxIndex=0;
        for(int i=1;i< words.length;i++)
        {
            if(words[maxIndex].length<words[i].length)
            {
                maxIndex=i;
            }
        }

        for(int i=0;i<words[maxIndex].length;i++)
        {
            System.out.print(words[maxIndex][i]+" ");
        }
    }
    public static void Task2()
    {
        String str;
        System.out.println("Введіть назву предмету: ");
        str=new Scanner(System.in).nextLine();
        String fileName=str+".txt";
        System.out.println(fileName);

        BufferedReader br=null;
        try
        {
            //Створення файлу
            File file=new File(fileName);
            if(!file.exists())
                file.createNewFile();
            PrintWriter pw=new PrintWriter(file);
            byte n;
            byte rating;
            String firName;
            //Запис інформації
            do {
                System.out.println("Прізвеще студена: ");   firName= new Scanner(System.in).nextLine();
                System.out.println("Оцінка:");  rating =new Scanner(System.in).nextByte();
                pw.println(firName+"-"+rating);
                System.out.println("1-Продовжити введення: \n 2-Зчитати данні:");
                n =new Scanner(System.in).nextByte();
            }while(n==1);
            pw.close();
            if(n==2) {
                br = new BufferedReader(new FileReader(fileName));
                String string;
                while ((string = br.readLine()) != null) {
                    System.out.println(string+"\t");
                }
            }
            else
                System.out.println("(");
        }catch(IOException e)
        {
            System.out.println("Error "+e);
        }
    }

    static int CountWords(String[] words)
    {
        int countWords=0;
        for(int i=0;i< words.length;i++)
        {
            if(words[i].length()%2!=0)
                countWords++;
        }
        return countWords;
    }

    static boolean Konteins(Character a, List<Character> b)
    {
        for(int i=0;i<b.size();i++)
        {
            if(b.get(i).equals(a))
                return true;
        }
        return false;
    }
    static void Chastota(String string)
    {
        List<Character> stringList=new ArrayList<Character>();
        char[] arr=string.toCharArray();

        for(int i=0;i<arr.length;i++)
        {
            stringList.add(arr[i]);
        }

       for (int i=0;i<stringList.size();i++)
       {
           if(stringList.get(i).equals(' '))
           {
               stringList.remove(i);
           }
       }

       List <Character> backList=new ArrayList<Character>();
       try {
           File file = new File("Output.txt");
           if (!file.exists())
               file.createNewFile();
           PrintWriter pw = new PrintWriter(file);
           for (int i = 0; i < stringList.size(); i++) {
               if (Konteins(stringList.get(i), backList) == false) {

                   System.out.print("Cимвол " + stringList.get(i));
                   int count = 0;
                   for (int j = 0; j < stringList.size(); j++) {
                       if (stringList.get(j).equals(stringList.get(i)))
                           count++;
                   }
                   System.out.println(": " + count);
                   pw.println("Cимвол " + stringList.get(i)+": "+count);
                   backList.add(stringList.get(i));
               }
           }
           pw.close();
       }catch(IOException e)
       {
           System.out.println("Помалка: "+ e);
       }
    }
    public  static void Task3()
    {
        BufferedReader br=null;
        String inputFileName="Input.txt";
        String outputFileName="Output.txt";

        try {
            String string=null;
            String string1="";
            br = new BufferedReader(new FileReader(inputFileName));
            while ((string = br.readLine()) != null) {
                 string1+=string;
            }
            System.out.println(string1);

            String[] words=string1.split("[ ]\\s*");
            System.out.println("Кількість не парних слів: "+CountWords(words));


            System.out.println("Часота повторення символів: ");
            Chastota(string1);
        }catch (IOException e)
        {
            System.out.println("Error "+e);
        }
    }

    public static void main(String[] args) {
        boolean run = true;
        byte number;
        Scanner num = new Scanner(System.in);
        while (true) {
            System.out.println("Введіть номер завдання(1-3;4-вихід)");
            number=num.nextByte();
            switch (number)
            {
                case 1:
                    System.out.println("Завдання №1: ");
                    Task1();
                    break;
                case 2:
                    System.out.println("Завдання №2: ");
                    Task2();
                    break;
                case 3:
                    System.out.println("Завдання №3: ");
                    Task3();
                case 4:
                    System.out.println("Вихід! ");
                    return;
                default:
                    System.out.println("Введи щераз!");
                    break;
            }


        }
        }

    }


