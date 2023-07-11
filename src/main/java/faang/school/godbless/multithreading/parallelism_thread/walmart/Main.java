package faang.school.godbless.multithreading.parallelism_thread.walmart;

import static faang.school.godbless.multithreading.parallelism_thread.walmart.Item.items;

public class Main {
    public static void main(String[] args) {
        items.add(new Item(1, "Bread", 5));
        items.add(new Item(2, "Bakery", 12));
        items.add(new Item(3, "Cookies", 10));
        items.add(new Item(4, "Coffee", 15));
        items.add(new Item(5, "Black Tea", 7));
        items.add(new Item(6, "Green Tea", 8));
        items.add(new Item(7, "Milk", 15));
        items.add(new Item(8, "Yogurt", 20));
        items.add(new Item(9, "Apple Juice", 21));
        items.add(new Item(10, "Orange Juice", 21));
        items.add(new Item(11, "Coke", 18));
        items.add(new Item(12, "Beer", 10));
        items.add(new Item(13, "Chocolate", 11));
        items.add(new Item(14, "Candies", 25));
        items.add(new Item(15, "Sausages", 31));
        items.add(new Item(16, "Hot dog", 35));
        items.add(new Item(17, "Stake", 40));

        // Создаем массив покупателей, каждый из которых имеет список товаров
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5},
                {12, 14, 12, 10, 5, 6, 17, 11},
                {1, 2, 3, 6, 4, 13, 12, 15}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All customers have finished served");
    }
}
