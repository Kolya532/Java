import TaskOne.Book;

import TaskTwo.TelephoneDirectory;
import TaskTwo.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1.Перше завдання." + "\n" +
                    "2.Друге завдання." + "\n" +
                    "3.Вихід." + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            switch (nomer) {
                case 1:
                    TaskOne();
                    break;
                case 2:
                    TaskTwo();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Не вірно введене число! Введіть ще раз :");
                    break;
            }
        }
    }


    /*
    * 23. Описати клас для бази зданих з інформацією про клієнтів банку з полями:
    дата проведення операції прізвище та ім’я, № рахунку, сума безготівкового
    отримання/переведення, отримано/видано готівкою, залишок вкладу.
    Вивести на екран у формі таблиці дані про клієнтів банку,
    які на протязі заданого періоду часу виконали безготівкове переведення на загальну суму,
    яка перевищує задане користувачем граничне значення.
    * */

    public static void TaskOne() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Олексій Васильєв ","Програмування мовою python",2011,"Типографія"));
        list.add(new Book("Роберт Мартін    ","Чиста архітектура         ",2016,"Типографія"));
        list.add(new Book("Олексій Васильєв ","програмування мовою java  ",2013,"Типографія"));
        list.add(new Book("Ерік Фрімен      ","Патерни проектування      ",2003,"Типографія"));
        list.add(new Book("Томас Кормен     ","Вступ до алгоритмів       ",2019,"Типографія"));
        list.add(new Book("Надія Балик      ","SQL практикум             ",2008,"Типографія"));
        list.add(new Book("Ерік Маттес      ","Пришвидшений курс Python  ",2007,"Типографія"));
        list.add(new Book("Роберт Мартін    ","Чистий код                ",2010,"Типографія"));
        list.add(new Book("Дакетт Джон      ","HTML і CSS                ",2002,"Типографія"));
        list.add(new Book("Олекій Васильєв  ","JavaScript в прикладах    ",2001,"Типографія"));

        list.sort(Comparator.comparing(Book::getYear));

        System.out.println("\nСписок проведених операцій клієнтами банку :");
        for (Book book : list) {
            System.out.println(book.toString());
        }


        System.out.println();
        for (Book book : list) {
            if(book.getNameBook().matches(".*[Пп]рограмування.*"))
                System.err.println(book.toString());
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void TaskTwo(){
        try {
            Scanner scanner = new Scanner(System.in);
            Task task = new Task();
            for(;;){
                System.out.println("\nadd - додати " + "\n" +
                        "edit - редагувати " + "\n" +
                        "print - висести список" + "\n" +
                        "search - пошук " + "\n" +
                        "sort - сортування " + "\n" +
                        "delete - видалити " + "\n" +
                        "exit - вихід");
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command){
                    case "add":
                        task.add();
                        break;
                    case "edit":
                        task.edit();
                        break;
                    case "print":
                        task.print();
                        break;
                    case "search":
                        task.search();
                        break;
                    case "sort":
                        task.sort();
                        break;
                    case "delete":
                        task.delete();
                        break;
                    case "exit":
                        return;
                }
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
