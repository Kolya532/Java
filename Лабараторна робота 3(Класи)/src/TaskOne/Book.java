package TaskOne;

import java.util.Scanner;

/*
* 2. Описати клас для бази зданих з інформацією про книги у формі: автор, назва книги, видавництво, рік видання.
* Вивести дані про книги з програмування (перевіряти, чи є частиною назви книги слово «програмування» з малої або великої літери)
*  у порядку спадання років видань.
 * */

public class Book {
    String author;
    String nameBook;
    int year;
    String Publishing_house;



    public Book() {
        author = "";
        nameBook = "";
        year = 0;
        Publishing_house = "";
    }

    public Book( String author, String nameBook, int year, String publishing_house ) {
        this.author = author;
        this.nameBook = nameBook;
        this.year = year;
        Publishing_house = publishing_house;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.print("Автор : ");
        author = scanner.nextLine();
        System.out.print("Назва книги : ");
        nameBook = scan.nextLine();
        System.out.print("Рік видання : ");
        year = scanner.nextInt();
        System.out.print("Видавництво : ");
        Publishing_house = scanner.nextLine();
    }



    @Override
    public String toString() {
        return author +
                "\t" + nameBook +
                "\t" + year +
                "\t" + Publishing_house
                ;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublishing_house() {
        return Publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.Publishing_house = publishing_house;
    }


}