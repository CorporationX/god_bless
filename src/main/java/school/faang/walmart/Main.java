package school.faang.walmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("item1", 20);
        Item item2 = new Item("item2", 40);
        Item item3 = new Item("item3", 50);
        Item item4 = new Item("item4", 30);
        Item item5 = new Item("item5", 80);
        Item item6 = new Item("item6", 100);

        ArrayList<Item> items1 = new ArrayList<>(List.of(item1, item2, item3, item4, item5, item6));
        ArrayList<Item> items2 = new ArrayList<>(List.of(item1, item2, item3, item5, item6));
        ArrayList<Item> items3 = new ArrayList<>(List.of(item2, item3, item4, item5, item6));
        ArrayList<List<Item>> customers = new ArrayList<>(List.of(items1, items2, items3));

        ArrayList<CashierThread> cashiers = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            CashierThread cashierThread = new CashierThread(i, customers.get(i));
            cashiers.add(cashierThread);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
