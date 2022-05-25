package com.company;
import java.io.*;
import java.util.*;

public class Main {

    private static Object IOException;

    static void Task1() throws IOException {
        int key;
        while (true) {
            System.out.println("1-Загрузити інформацію в файл: \n2-Зчитати інформацію з файла");
            key = new Scanner(System.in).nextInt();
            if (key != 1 && key != 2) {
                System.out.println("Не коректне значення");
            } else
                break;
        }
        String fileName = "Klients.txt";
        BufferedReader br = null;
        File file = new File(fileName);
        if (key == 1) {
            List<Klient> klients = new ArrayList<>();

            klients.add(new Klient(1,"Клієнт 1",34,1));
            klients.add(new Klient(2,"Клієнт 2",34,2));
            klients.add(new Klient(3,"Клієнт 3",34,3));
            klients.add(new Klient(4,"Клієнт 4",34,4));
            klients.add(new Klient(5,"Клієнт 5",34,5));

            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(klients);
            writeStream.flush();
            writeStream.close();
            System.out.println("Інформацію додано");
            Task1();

        } else if (key == 2) {
            List<Klient> usersRider = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usersRider = (List) ois.readObject();
                ois.close();
                System.out.println("Данні зчитино.");
            } catch (FileNotFoundException | ClassNotFoundException e) {
                System.out.println("Помилка: " + e);
                Task1();
            }
            int k;
            while (true) {
                System.out.println("\n1-Вивести інормацію. \n2-Найбільша кількість операцій.\n4-Вихід");
                k = new Scanner(System.in).nextInt();
                if (k == 1) {
                    System.out.println("Вивід інформації з файла");
                    for (Klient n : usersRider) {
                        n.Output();
                    }
                } else if (k == 2) {
                    Klient_Interface maxOperation =new Klient();
                    maxOperation=usersRider.get(0);
                        for(int i=0;i<usersRider.size();i++)
                        {
                            if(maxOperation.getCount_operation()<usersRider.get(i).getCount_operation())
                                maxOperation=usersRider.get(i);
                        }
                        maxOperation.Output();
                } else if (k == 4) {
                    System.out.println("Вихід із завдання!");
                    return;
                } else {
                    System.out.println("Невірно введенне значення!");
                    k = new Scanner(System.in).nextInt();
                }
            }
        }
    }

    static int countDay(List<Day> days)
    {
        int count =0;
        for(int i=0;i<days.size();i++)
        {
            if(days.get(i).getCountBookV()>days.get(i).getCountBookP())
                count++;
        }
        return count;
    }
    static void Day(List<Day> days)
    {
        int count =0;
        for(int i=0;i<days.size();i++)
        {
            if(days.get(i).getCountBookV()%2==0&&days.get(i).getCountBookP()%2!=0)
                days.get(i).Output();
        }
    }
    static Date InputDate()
    {
        System.out.println("Рік: "); int year=new Scanner(System.in).nextInt();
        System.out.println("Місяць: "); int month=new Scanner(System.in).nextInt();
        System.out.println("День: "); int day=new Scanner(System.in).nextInt();
        return new Date(year-1900,month-1,day);
    }
    static void Span(List<Day> days, Date before, Date after)
    {
        for (Day n:days) {
            if(n.getDate().after(before)&&n.getDate().before(after)) {
                n.Output();
            }
        }
    }
    static void Task2() throws IOException {
        int key;
        while (true) {
            System.out.println("1-Загрузити інформацію в файл: \n2-Зчитати інформацію з файла");
            key = new Scanner(System.in).nextInt();
            if (key != 1 && key != 2) {
                System.out.println("Не коректне значення");
            } else
                break;
        }

        String fileName = "Days.txt";
        BufferedReader br = null;
        File file = new File(fileName);
        if (key == 1) {
            List<Day> days = new ArrayList<Day>();
            days.add(new Day("Білбіотека 1", "Aдрес1", new Date(2022 - 1900, 05 - 1, 23), 3, 4));
            days.add(new Day("Білбіотека 2", "Aдрес2", new Date(2022 - 1900, 05 - 1, 22), 6, 8));
            days.add(new Day("Білбіотека 3", "Aдрес3", new Date(2022 - 1900, 05 - 1, 21), 3, 2));
            days.add(new Day("Білбіотека 4", "Aдрес4", new Date(2022 - 1900, 05 - 1, 20), 5, 4));
            days.add(new Day("Білбіотека 5", "Aдрес5", new Date(2022 - 1900, 05 - 1, 19), 6, 7));
            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(days);
            writeStream.flush();
            writeStream.close();
            System.out.println("Інформацію додано");
            Task2();
        } else if (key == 2) {
            List<Day> usersRider = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usersRider = (List) ois.readObject();
                ois.close();
                System.out.println("Данні зчитино.");
            } catch (FileNotFoundException | ClassNotFoundException e) {
                System.out.println("Помилка: " + e);
                Task1();
            }
            int k;
            while (true) {
                System.out.println("\n1-Вивести інормацію. \n2-Кількість книг коли було видано більше ніж повернуто: \n3-Дні, коли видана парна кількість книг, а повернута –непарна \n4-Дати на проміжку \n5-Вихід");
                k = new Scanner(System.in).nextInt();
                if (k == 1) {
                    System.out.println("Вивід: ");
                    for (Day n : usersRider) {
                        n.Output();
                    }
                } else if (k == 2) {
                    System.out.println("Кількість книг коли було видано більше ніж повернуто: "+countDay(usersRider));
                } else if (k == 3) {
                   System.out.println("Дні, коли видана парна кількість книг, а повернута –непарна");
                    Day(usersRider);
                } else if (k == 4) {
                    System.out.println("Перший проміжок: ");
                    Date oneDate = InputDate();
                    System.out.println("Другий проміжок: ");
                    Date twoDate = InputDate();
                    if (twoDate.after(oneDate)) ;
                    {
                        System.out.println("Проміжок не підходить!");
                    }
                    Span(usersRider, oneDate, twoDate);
                } else if (k == 5) {
                    System.out.println("Вихід із завдання!");
                    return;
                } else {
                    System.out.println("Невірно введенне значення!");
                    k = new Scanner(System.in).nextInt();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int k;
        while (true) {
            System.out.println("Введіть номер завдання: ");
            System.out.println("1-1 завдання: \n2-2 завдання: \n3-вихід");
            k = new Scanner(System.in).nextInt();
            if (k == 1)
            {
                Task1();
            }
            else if (k == 2)
            {
                Task2();
            }
            else if (k == 3)
                return;
            else
            {
                System.out.println("Введіть щераз: ");
                k = new Scanner(System.in).nextInt();
            }
        }
    }
}
