package faang.school.godbless.Walmart.Queue;

import java.util.List;
import java.util.Random;

public class Walmart {
    public static void main(String[] args) throws InterruptedException {
        Item[][] customers = new Item[10][3];
        CashierThread[] cashiers = new CashierThread[10];

        List<Item> items = List.of(new Item("Молоко", 15),
                new Item("Яйца", 20),
                new Item("Мука", 17),
                new Item("Сыр", 70),
                new Item("Сникерс", 8),
                new Item("Туалетная бумага", 12));

        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < customers[i].length; j++) {
                customers[i][j] = items.get(new Random().nextInt(5));
            }
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].start();
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].join();
        }

        System.out.println("Вывод через метод printInfo():"); //Ничего не выводит без join()

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].printInfo(); //Работает без join(), нулевой поток выводит нулевые значения без join()
        }
    }
}
