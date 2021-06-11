import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//@author pro100user

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Перше завдання.");
        System.out.println("2. Друге завдання.");
        System.out.println("3. Третє завдання.");
        System.out.println("4. Четверте завдання.");
        System.out.println("5. Вихід.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while(num != 5){
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
                    case 4:
                        task4();
                        break;
                    default:
                        System.out.println("Не вірно введене число!!! Повторіть спробу :");
                        break;
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("1. Перше завдання.");
            System.out.println("2. Друге завдання.");
            System.out.println("3. Третє завдання.");
            System.out.println("4. Четверте завдання.");
            System.out.println("5. Вихід.");
            System.out.print("Введіть число : ");
            num = scanner.nextInt();
        }
    }


    /*
     * 2. За введеним номером у списку групи (від 1 до 10) вивести прізвище та ім’я одногрупника.
     * */
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер студента : ");
        int name = scanner.nextInt();
        do {
            if (name >= 1 && name <= 10) {
                switch (name) {
                    case 1:
                        System.out.println("Бужняк Микола");
                        break;
                    case 2:
                        System.out.println("Васенков Дмитро");
                        break;
                    case 3:
                        System.out.println("Гакман Василь");
                        break;
                    case 4:
                        System.out.println("Гарасим'юк Павло");
                        break;
                    case 5:
                        System.out.println("Даниленко Максим");
                        break;
                    case 6:
                        System.out.println("Кабісов Сергій");
                        break;
                    case 7:
                        System.out.println("Казюк Артур");
                        break;
                    case 8:
                        System.out.println("Клим Петро");
                        break;
                    case 9:
                        System.out.println("Нищук Максим");
                        break;
                    case 10:
                        System.out.println("Полянський Михайло");
                        break;
                }
                break;
            } else {
                System.out.print("Введіть прізвище та ім'я  : ");
                name = scanner.nextInt();
            }
        } while (true);
    }


    /*
     * 2. Протабулювати функцію y=f(x), з параметром x, який змінюється від 'a' до 'b' з кроком h
     * */
    public static void task2() throws IOException {
        int a = 1, b = 6;
        double dx = 0.2;
        double x = a;
        do {
            double y = Math.log(x);
            System.out.println("x = " + String.format("%.2f", x) + "\ty = "+ String.format("%.2f", y));
            x += dx;
        }while(x <= b);
    }



    /*
     * 2. Визначити : 1)максимальний елемент масиву;
     * 2) суму елементів масиву, розташованих між першим й другим додатними елементами.
     * */
    public static void task3() throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(100) - 50;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();


        int min = mas[0], max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
        }
        System.out.println("Максимальний елемент масиву:" + max);

        if(mas.length < 2)
            throw new IllegalAccessException("Елементів не достатньо!");

        int index1 = -1, index2 = -1;
        for(int i=0;i<mas.length;i++){
            if(mas[i] > 0 && index1 == -1) {
                index1 = i;
                continue;
            }
            if(mas[i] > 0 && index2 == -1)
                index2 = i;
        }

        if(index1 == -1 || index2 == -1)
            throw new IllegalAccessException("Додатніх елементів не достатньо!");

        if(index1 == index2)
            System.out.println("Сума між додатніми елементами: 0");

        int suma = 0;
        for(int i=index1 + 1; i<index2; i++){
            suma+=mas[i];
        }

        System.out.println("Сума між додатніми елементами:" + suma);
    }


    /*
     * 2.  Дано цілочислову матрицю А розмірності nxm. В ній 2 найбільші елементи замінити нулями
     * */
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть висоту матриці : ");
        int n = scanner.nextInt();
        System.out.print("Введіть ширину матриці : ");
        int m = scanner.nextInt();
        for (; ; ) {
            if (n < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть висоту матриці : ");
                n = scanner.nextInt();
            }
            if (m < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть ширину матриці : ");
                m = scanner.nextInt();
            }
            if (n > 0 && m > 0) break;
        }
        int[][] mas = new int[n][m];
        System.out.println("1.Ввести матрицю з клавіатури.");
        System.out.println("2.Згенерувати матрицю.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести матрицю з клавіатури.");
                System.out.println("2.Згенерувати матрицю.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("A [" + i + "][" + j + "] = ");
                    mas[i][j] = scanner.nextInt();
                }
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mas[i][j] = random.nextInt(200) - 100;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        int max1 = mas[0][0], max2 = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > max2 || (i1 == i2 && j1 == j2)) {
                    max2 = mas[i][j];
                    i2 = i;
                    j2 = j;
                }
                if (mas[i][j] > max1) {
                    max2 = max1;
                    i2 = i1;
                    j2 = j1;
                    max1 = mas[i][j];
                    i1 = i;
                    j1 = j;
                }
            }
        }
        mas[i1][j1] = 0;
        mas[i2][j2] = 0;

            System.out.println("Результат :");
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }