package faang.school.godbless.walmart_queue;

import java.util.ArrayList;
import java.util.List;

public class WallMart {

    public static void main(String[] args) {

        List<CashierThread> cashiers = new ArrayList<>();
        List<List<Item>> customers = List.of(List.of(new Item("Orange", 10), new Item("Banana", 20), new Item("Apple", 30)),
                List.of(new Item("Orange", 10), new Item("Banana", 20), new Item("Apple", 30), new Item("Chocolate", 50)),
                List.of(new Item("Orange", 10), new Item("Banana", 20), new Item("Apple", 30), new Item("Water", 5)));

        for (int i = 0; i < customers.size(); i++) {
            CashierThread cashier = new CashierThread(i, customers.get(i));
            cashiers.add(cashier);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
