import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Перше завдання.");
        System.out.println("2. Друге завдання.");
        System.out.println("3. Третє завдання.");
        System.out.println("4. Вихід.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (num != 4) {
            try {
                switch (num) {
                    case 1:
                        task1();
                        break;
                    case 2:
                        task2();
                        break;
                    case 3:
                        task3();
                        break;
                    default:
                        System.out.println("Не вірно введене число!!! Повторіть спробу :");
                        break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("1. Перше завдання.");
            System.out.println("2. Друге завдання.");
            System.out.println("3. Третє завдання.");
            System.out.println("4. Вихід.");
            System.out.print("Введіть число : ");
            num = scanner.nextInt();
        }
    }




    /*
     * 2. а) підраховує кількість цифр у тексті; б) виводить на екран слова, що починаються з приголосних літер.
     * */
    public static void task1() {
        String text = "2 і 3 4 6 пара java ";
        long count = text.codePoints().filter(Character::isDigit)
                .count();
        System.out.println("2 і 3 пара java");
        System.out.println("Кількість цифр в рядку :    " + count);
        System.out.println("//////////////////////////////////");
        String text1 = "івапіва овр ркоав приат крпав";
        char charTmp;
        for (String word : text1.split("\\s+")){
            charTmp = word.toLowerCase().charAt(0);
            if (Character.isLetter(charTmp))
                switch (charTmp) {
                    case 'а':
                    case 'у':
                    case 'е':
                    case 'и':
                    case 'і':
                    case 'о':
                        break;
                    default:
                        System.out.println(word);
                }
        }
    }
    private static String fileReader (String path) throws IOException {
        //створюємо обєкт File
        File isFile = new File(path);
        //перевіряєм на наявність цього файла на комп'ютері
        //якщо його немає, то викидається помилка IOException
        if(!isFile.isFile()) throw new IOException("Файл не знайдено!");
        //створюємо обєкт BufferedReader для зчитування данних з файла
        //@Cleanup - завдяки цьому , метод Close() виконається автоматично при виході з метода
        BufferedReader reader = new BufferedReader(new FileReader(path));
        //створюємо обєкт String для построкового считування данних з файла
        String line;
        //створюємо обєкт BufferedReader для швидкої контенентація строк
        StringBuilder lines = new StringBuilder();
        //построкове считування данних з файла
        while ((line = reader.readLine()) != null) {
            lines.append(line);
        }
        //Повертаєм увесь считаний текст з файла
        return lines.toString();
    }

    /*
     * 2. Задано текстовий файл. Підрахувати кількість входжень в нього кожної з голосних букв
     * */
    public static void task2() throws IOException {
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get("g.txt")));
        } catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        s = s.replaceAll("[^aoeuiy]", "");
        System.out.println("Кількість голосних букв: " + s.length());
    }





    /*
     * 2.Дано текстовий файл. Видалити з перший нього рядок в кінці якого знаходиться символ "!". Результат записати в новий файл.
     * */
    public static void task3() throws IllegalAccessException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader("input.txt"));
             PrintWriter outputStream = new PrintWriter(new FileWriter("output.txt"))) {
            String l;
            boolean ok = false;
            while ((l = inputStream.readLine()) != null) {
                if ((l.indexOf('!') == l.length() - 1) & !ok) {
                    ok = true;
                } else outputStream.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

