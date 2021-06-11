package TaskTwo;

import java.io.*;
import java.util.*;

/*
* Розробити консольний застосунок для роботи з базою даних, що зберігається у текстовому файлі
* (початковий масив не менше 10 записів). Структура бази даних описується класом згідно вашого варіанта.
* Передбачити роботу з довільною кількістю записів. Для ідентифікації спроби введення з клавіатури
* некоректних даних описати виключення. Всі поля класу зробити закритими, а доступ до них реалізувати
* через get i set. Реалізувати конструктори з параметрами та без параметрів, а ініціалізацію полів
* виконати через властивості.
*
* Реалізувати методи для:
– додавання записів;
– редагування записів;
– знищення записів;
– виведення інформації з файла на екран;
– пошук потрібної інформації за конкретною ознакою (поле Параметр пошуку);
– сортування за різними полями (поле Параметр сортування).
Меню програми реалізувати по натисненню на певні клавіші:
наприклад, Enter – вихід, п - пошук, р – редагування тощо.
* */

public class Task {
     ArrayList<TelephoneDirectory> telephoneDirectory;

     public Task() throws IOException {
          telephoneDirectory = read_from_file("Movies.txt");
     }

     public void add() throws IOException{
          TelephoneDirectory new_telephoneDirectory = new TelephoneDirectory();
          System.out.println("\nВведіть інформацію :");
          new_telephoneDirectory.input();
          telephoneDirectory.add(new_telephoneDirectory);

          System.out.println("\nЗапис доданий!");

          this.write_to_file("Movies.txt");
     }

     public void edit() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          System.out.print("\nВведіть номер, який ви хочете редагувати : ");
          String line = scanner.nextLine();
          if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > telephoneDirectory.size()){
               System.err.println("Не вірно введений номер!");
               this.edit();
               return;
          }
          int nomer = Integer.parseInt(line);
          nomer--;

          System.out.println("\nВідредагуйте :");
          telephoneDirectory.get(nomer).input();
          System.out.println("\nРедагування пройшло успішно!");

          this.write_to_file("Movies.txt");
     }

     public void print() throws IOException {
          count_note();

          int i = 0;
          System.out.println("\nІнформація про людину :");
          for (var p:
                  telephoneDirectory) {
               System.out.println("\nЗапис №" + (i + 1) + " :");
               p.print();
               i++;
          }
     }

     public void search() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          System.out.println("\nВведіть прізвище, яке ви шукаєте : ");
          String surname = scanner.nextLine();

          boolean flag = false;
          int i = 0;
          for (var p:
                  telephoneDirectory) {
               if(p.getSurname().equals(surname)) {
                    if(flag == false){
                         System.out.println("\nРезультат : ");
                         flag = true;
                    }
                    System.out.println("Запис №" + (i + 1) + " :");
                    p.print();
                    System.out.println();
                    i++;
               }
          }

          if(flag == false){
               System.out.println("Пошук не вдалий!");
          }
     }

     public void sort() throws IOException {
          count_note();

          ArrayList<TelephoneDirectory> sortTelephone = new ArrayList<TelephoneDirectory>(telephoneDirectory);
          sortTelephone.sort(Comparator.comparing(TelephoneDirectory::getPhone));

          int i = 0;
          System.out.println("\nВідсортований список :");
          for (var p: sortTelephone) {
               System.out.println("\nЗапис №" + (i + 1) + " :");
               p.print();
               i++;
          }
     }

     public void delete() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          System.out.print("\nВведіть номер, який ви хочете видалити : ");
          String line = scanner.nextLine();
          if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > telephoneDirectory.size()){
               System.err.println("Не вірно введений номер!");
               this.delete();
               return;
          }
          int surname = Integer.parseInt(line);
          surname--;

          telephoneDirectory.remove(surname);
          System.out.println("\nВидалення пройшло успішно!");

          this.write_to_file("Movies.txt");
     }

     public void count_note() throws IOException {
          if(telephoneDirectory.size() == 0)
               throw new IOException("Записів нема!");
     }

     private static void isFile(String filepath) throws IOException{
          //перевірка чи файл існує
          File file = new File(filepath);
          if(!file.isFile()) throw new IOException("Файл не знайдено!");
          //file.createNewFile();
     }


     public void write_to_file(String filepath) throws IOException{
          isFile(filepath);

          BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
          for (var p:
                  telephoneDirectory) {
               output.write(p.to_string());
          }
          output.flush();
          output.close();
          output.close();
     }


     private static ArrayList<TelephoneDirectory> read_from_file(String filepath) throws IOException {
          isFile(filepath);

          BufferedReader reader = new BufferedReader(new FileReader(filepath));
          String text;
          ArrayList<TelephoneDirectory> arrayList = new ArrayList<>();
          TelephoneDirectory movies;
          while ((text = reader.readLine()) != null) {
               arrayList.add(new TelephoneDirectory(text, reader.readLine(), Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine()));
          }
          reader.close();
          return arrayList;
     }
}
