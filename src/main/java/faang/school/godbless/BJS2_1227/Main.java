package faang.school.godbless.BJS2_1227;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Item>> customers = initCustomers();
        List<Thread> cashiers = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            cashiers.add(new CashierThread(customers.get(i), i));
        }

        for (Thread cashier : cashiers) {
            cashier.start();
        }
    }

    private static List<List<Item>> initCustomers() {
        return List.of(
                List.of(new Item("Coke"), new Item("Pizza")),
                List.of(new Item("Apple Juice"), new Item("Orange Juice"), new Item("Ice cream"), new Item("Bread")),
                List.of(new Item("Bike"), new Item("Water"), new Item("Snack"))
        );
    }
}