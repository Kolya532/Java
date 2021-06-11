package TaskTwo;

/*
Варіант 2
Клас : Телефонний довідник
Поля : Прізвище, ім'я, по батькові, адреса, телефон
Параметр сортування : Телефон
Параметр пошуку : Прізвище
* */

import java.util.Scanner;

public class TelephoneDirectory {
    String surname;
    String name;
    int phone;
    String adresa;
    String PoBatkovi;

    public TelephoneDirectory() {
        surname = "";
        name = "";
        phone = 0;
        adresa = "";
        PoBatkovi = "";
    }

    public TelephoneDirectory( String surname, String name, int phone, String adresa, String PoBatkovi) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.adresa = adresa;
        this.PoBatkovi = PoBatkovi;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Прізвище : ");
        surname = scanner.nextLine();
        System.out.print("Ім'я : ");
        name = scanner.nextLine();
        System.out.print("По-Батькові : ");
        PoBatkovi = scanner.nextLine();
        System.out.print("Телефон : ");
        phone = scanner.nextInt();
        System.out.print("Адреса : ");
        scanner.nextLine();
        adresa = scanner.nextLine();

    }

    public void print() {
        System.out.println("Прізвище : " + surname);
        System.out.println("Ім'я - " + name);
        System.out.println("По-батькові - " + PoBatkovi);
        System.out.println("Телефон - " + phone);
        System.out.println("Адреса - " + adresa);

    }

    @Override
    public String toString() {
        return "Telephone{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", adresa='" + adresa + '\'' +
                ", PoBatkovi=" + PoBatkovi +
                '}';
    }

    public String to_string() {
        return  surname + '\n' +
                name + '\n' +
                phone + '\n' +
                adresa + '\n' +
                PoBatkovi + '\n'
                ;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPoBatkovi() {
        return PoBatkovi;
    }

    public void setPoBatkovi(String poBatkovi) {
        this.PoBatkovi = poBatkovi;
    }

}
