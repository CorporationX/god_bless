package faang.school.godbless;

import faang.school.godbless.walmart.CashierThread;
import faang.school.godbless.walmart.Item;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Application {

    @SneakyThrows
    public static void main(String... args) {

        List<List<Item>> customers = new ArrayList<>();
        List<CashierThread> cashiers = new ArrayList<>();

        Item chicken = new Item("Chicken", 10);
        Item apples = new Item("Apples", 3);
        Item porsche = new Item("Porsche 911", 200_000);
        Item macBook = new Item("MacBook Pro M2", 2000);

        List<Item> vlad = List.of(chicken, apples, porsche, macBook);

        Item beer = new Item("Dunkel Bier", 2);
        Item tomatoes = new Item("Tomaten", 3);
        Item surfaceBook = new Item("Microsoft Surface Laptop 5", 1500);
        Item bmw = new Item("BMW i8", 250_000);

        List<Item> vitalii = List.of(beer, tomatoes, beer, surfaceBook, beer, bmw, beer);

        Item hogwarts = new Item("Hogwarts Legacy", 50);
        Item lor = new Item("Lord of the Rings full Series", 150);
        Item carrots = new Item("Carrots", 3);
        Item dragon = new Item("Dragon", 1_000_000);

        List<Item> inna = List.of(hogwarts, lor, carrots, apples, dragon);

        customers.add(vlad);
        customers.add(vitalii);
        customers.add(inna);

        int totalSum = 0;

        for (int i = 0; i < customers.size(); i++) {
            cashiers.add(new CashierThread(i+1, customers.get(i)));
        }

        for (var cashier : cashiers) {
            cashier.start();
        }

        for (var cashier : cashiers) {
            try {
                cashier.join();
                totalSum += cashier.getTotalCost();
            } catch (InterruptedException e) {
                throw new InterruptedException("Well, not this time...");
            }
        }

        System.out.println("\nLady and gentlemen, you've got " + totalSum + "$ to pay. We hope, Vlad has some cash?");
    }
}
