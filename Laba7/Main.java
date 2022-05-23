package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    private static Object IOException;
    private static Object ClassNotFoundException;


        static void Task1() throws IOException, ClassNotFoundException {
        int key;
        while (true) {
            System.out.println("1-Загрузити інформацію в файл: \n2-Зчитати інформацію з файла");
            key = new Scanner(System.in).nextInt();
            if (key != 1 && key != 2) {
                System.out.println("Не коректне значення");
            } else
                break;
        }

        String fileName = "Hours.txt";
        BufferedReader br = null;
        File file = new File(fileName);
        if (key == 1) {
            List<Hour> hours = new ArrayList<>();
            hours.add(new Hour("Книжний1","Шкільна1",23,"Коментар1"));
            hours.add(new Hour("Книжний2","Шкільна2",19,"Коментар2"));
            hours.add(new Hour("Книжний3","Шкільна3",16,"Коментар3"));
            hours.add(new Hour("Книжний4","Шкільна4",25,"Коментар4"));
            hours.add(new Hour("Книжний5","Шкільна5",19,"Коментар5"));

            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(hours);
            writeStream.flush();
            writeStream.close();
            System.out.println("Інформацію додано");
            Task1();

        } else if (key == 2) {
            List<Hour> usersRider = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usersRider = (List) ois.readObject();
                ois.close();
                System.out.println("Данні зчитино.");
            } catch (FileNotFoundException | java.lang.ClassNotFoundException e) {
                System.out.println("Помилка: " + e);
                Task1();
            }
            int k;
            while (true) {
                System.out.println("\n1-Вивести інормацію. \n2-Загальна кількість покупців. \n 3-Найменша кількість покупців\n4- Пошук по коменту:\n5-Вихід");
                k = new Scanner(System.in).nextInt();
                if (k == 1) {
                    System.out.println("Вивід інформації з файла");
                    for (Hour n : usersRider) {
                        n.Output();
                    }
                } else if (k == 2) {
                    int count=0;
                    for (Hour a:usersRider) {
                        count=count+a.getCountPokup();
                    }
                    System.out.println("Загальна кількість покупців: "+count);
                } else if (k == 3) {
                    int minIndex=0;
                    for (int i=0;i<usersRider.size();i++) {
                        if(usersRider.get(i).getCountPokup()<usersRider.get(minIndex).getCountPokup())
                        {
                            minIndex=i;
                        }
                    }
                    usersRider.get(minIndex).Output();

                } else if(k==4)
                {
                    boolean t=false;
                    System.out.println("Введіть коментар:");
                    String serch= new Scanner(System.in).nextLine();
                    for (Hour a:usersRider) {
                        if(a.SComent(serch)) {
                            a.Output();
                            t=true;
                        }
                    }
                    if(t==false)
                        System.out.println("Нічого немає!");
                }
                    else if (k == 5) {
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
	Task1();
    }
}
