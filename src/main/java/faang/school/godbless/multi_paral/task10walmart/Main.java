package faang.school.godbless.multi_paral.task10walmart;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Item[][] customers = {
                {new Item("Хлеб", 31), new Item("Молоко", 78), new Item("Яблоки", 156)},
                {new Item("Сок", 87), new Item("Чипсы", 133), new Item("Шоколад", 45)},
                {new Item("Сок", 102), new Item("Чипсы", 57), new Item("Шоколад", 76)},
        };

        CashierThread[] cashiers = new CashierThread[customers.length];


        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("Покупатели обслужены");
    }
}
