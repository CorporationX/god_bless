package faang.school.godbless.walmart_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PaymentTaker totalEarn = new PaymentTaker();
        Map<String, Integer> soldItemsLogger = new HashMap<>();

        List<CashierThread> cashierThreadList = getCashierThreads(totalEarn, soldItemsLogger);

        cashierThreadList.forEach(Thread::start);

        cashierThreadList.forEach(cashierThread -> {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Something went wrong during join: " + e.getMessage());
            }
        });

        System.out.println("Total earn: " + totalEarn);
        System.out.println("Total sold items: " + soldItemsLogger);
    }

    private static List<List<Item>> getCustomers() {
        return List.of(
                List.of(new Item("Cheese", 2000), new Item("Bread", 100), new Item("Tea", 250)),
                List.of(new Item("Souse", 300), new Item("Book", 2100), new Item("Lemon", 200)),
                List.of(new Item("Apples", 450), new Item("Apples", 500), new Item("Carrot", 650)),
                List.of(new Item("Bananas", 1000), new Item("Bubble Gum", 340), new Item("Jam", 800)),
                List.of(new Item("Fruits", 2000), new Item("Meat", 2600), new Item("Tea", 250))
        );
    }

    private static List<CashierThread> getCashierThreads(PaymentTaker paymentReference,
                                                         Map<String, Integer> soldItemsLogger) {
        Random randomizer = new Random();
        List<List<Item>> customers = getCustomers();
        List<CashierThread> cashierThreads = new ArrayList<>();

        for (List<Item> customer : customers) {
            cashierThreads.add(new CashierThread(randomizer.nextInt(1, 100), customer,
                    paymentReference, soldItemsLogger));
        }

        return cashierThreads;
    }
}
