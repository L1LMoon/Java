package com.company;
import java.io.*;
import java.util.*;

public class Main {


    static void Task1() {
        List<Spost> list = new ArrayList<>();
        byte num;
        System.out.println("1-Ввести інформацію з клавіатури: \n2-Загрузити інормацію ");
        num = new Scanner(System.in).nextByte();
        byte c = 1;
        if (num == 1) {
            while (c == 1) {
                System.out.println("Рік = ");
                int years = new Scanner(System.in).nextInt();
                System.out.println("Місяць = ");
                int month = new Scanner(System.in).nextInt();
                System.out.println("День = ");
                int day = new Scanner(System.in).nextInt();
                Date date = new Date(years-1900, month-1, day);
                System.out.println("Температура =  ");
                int temp = new Scanner(System.in).nextInt();
                System.out.println("Тиск = ");
                int tisk = new Scanner(System.in).nextInt();
                if (years < 0 || day < 0 || day > 31 || month < 0 || month > 12 || temp < 0 || tisk < 0) {
                    System.out.println("Введенні некоректні данні! ");
                    Task1();
                }
                list.add(new Spost(date, temp, tisk));
                System.out.println("1-продовжети введення \n *Любе інше значення*-закінчити введення \n*");
                c = new Scanner(System.in).nextByte();
            }


        } else if (num == 2) {

            list.add(new Spost(new Date(2022-1900, 05-1, 1), 15, 765));
            list.add(new Spost(new Date(2022-1900, 05-1, 2), 19, 749));
            list.add(new Spost(new Date(2022-1900, 05-1, 3), 17, 777));
            list.add(new Spost(new Date(2022-1900, 05-1, 4), 15, 780));
            list.add(new Spost(new Date(2022-1900, 05-1, 5), 13, 730));
            list.add(new Spost(new Date(2022-1900, 05-1, 6), 19, 715));
            list.add(new Spost(new Date(2022-1900, 05-1, 7), 21, 760));
            list.add(new Spost(new Date(2022-1900, 03-1, 8), 17, 790));
            list.add(new Spost(new Date(2022-1900, 03-1, 9), 16, 761));
            list.add(new Spost(new Date(2022-1900, 03-1, 10), 15, 782));
        } else {
            System.out.println("Невірне значення!! ");
            Task1();
        }
        //Середнє значення
        float serTisk = 0;
        for (Spost n : list) {
            serTisk = serTisk + n.getTisk();
        }
        serTisk = serTisk / list.size();
        System.out.println("Середнє значення атмосферного тиску: " + serTisk + "\nВивід записів в яких атмосферний тиск більший за середній: ");
        for (Spost n : list) {
            if(n.ChekTisk(serTisk))
                n.Output();
        }
    }


    static void Serch(List<User> users, String Serch) {
        boolean a = false;
        for (User n : users) {
            if (n.getSurName().equals(Serch)) {
                n.Output();
                a = true;
            }
        }
        if (!a)
            System.out.println("Нічого не знайденно!");
    }

    static void Task2() throws IOException, ClassNotFoundException {
        int key;
        while (true) {
            System.out.println("1-Загрузити інформацію в файл: \n2-Зчитати інформацію з файла");
            key = new Scanner(System.in).nextInt();
            if (key != 1 && key != 2) {
                System.out.println("Не коректне значення");
            } else
                break;
        }

        String fileName = "User.txt";
        BufferedReader br = null;
        File file = new File(fileName);
        if (key == 1) {
            List<User> users = new ArrayList<>();
            users.add(new User("Флорескул", "floreskul@gmail.com", true));
            users.add(new User("Артеменко", "artemenko@gmail.com", true));
            users.add(new User("Вася1", "vasya1@gmail.com", false));
            users.add(new User("Вася2", "vasya2@gmail.com", false));
            users.add(new User("Вася3", "vasya3@gmail.com", false));
            users.add(new User("Вася4", "vasya4@gmail.com", false));
            users.add(new User("Вася5", "vasya5@gmail.com", false));
            users.add(new User("Вася6", "vasya6@gmail.com", true));
            users.add(new User("Вася7", "vasya7@gmail.com", false));
            users.add(new User("Вася8", "vasya8@gmail.com", false));

            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(users);
            writeStream.flush();
            writeStream.close();
            System.out.println("Інформацію додано");
            Task2();

        } else if (key == 2) {
            List<User> usersRider = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usersRider = (List) ois.readObject();
                ois.close();
                System.out.println("Данні зчитино.");
            } catch (FileNotFoundException e) {
                System.out.println("Помилка: " + e);
                Task2();
            }
            int k;
            while (true) {
                System.out.println("\n1-Вивести інормацію. \n2-Пошук по прізвищу. \n 3-Сортування по типу аккаунту.\n4-Вихід");
                k = new Scanner(System.in).nextInt();
                if (k == 1) {
                    System.out.println("Вивід інформації з файла");
                    for (User n : usersRider) {
                        n.Output();
                    }
                } else if (k == 2) {
                    String serch;
                    System.out.println("Введіть прізвище: ");
                    serch = new Scanner(System.in).nextLine();
                    Serch(usersRider, serch);
                } else if (k == 3) {

                    for (int i =0;i<usersRider.size()-1;i++)
                    {
                        for (int j=0;j<usersRider.size()-1;j++)
                        {
                            if(usersRider.get(j).getTypeLogin()==false && usersRider.get(j+1).getTypeLogin()==true)
                            {
                                User tmp;
                                tmp= usersRider.get(j);
                                usersRider.set(j,usersRider.get(j+1));
                                usersRider.set(j+1,tmp);
                            }
                        }
                    }

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int k;
        while (true) {
            System.out.println("Введіть номер завдання: ");
            System.out.println("1-1 завдання: \n2-2 завдання: \n3-вихід");
            k = new Scanner(System.in).nextInt();
            if (k == 1)
                Task1();
            else if (k == 2)
                Task2();
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
