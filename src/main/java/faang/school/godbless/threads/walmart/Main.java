package faang.school.godbless.threads.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<CashierThread> cashiers = initCashiersThreads();
        for (CashierThread cashierThread : cashiers) {
            cashierThread.start();
        }
        for (CashierThread cashierThread :cashiers) {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalCountItems = cashiers.stream().map(cashier -> cashier.getCountItems()).reduce(0, Integer::sum);
        int totalPrice = cashiers.stream().map(cashier -> cashier.getPriceSum()).reduce(0, Integer::sum);
        System.out.println("============================================\n" +
                "Всеми кассирами было пробито " + totalCountItems + " товаров на сумму " + totalPrice +
                "\n============================================");
    }

    private static List<List<Item>> initItemList() {
        return List.of(List.of(Item.COFFEE, Item.BREAD),
                List.of(Item.CARROT, Item.COLA, Item.BREAD),
                List.of(Item.CUCUMBER, Item.BREAD, Item.TEA),
                List.of(Item.TOMATO, Item.YOUGURT),
                List.of(Item.MILK));
    }

    private static List<CashierThread> initCashiersThreads() {
        List<List<Item>> customers = initItemList();
        List<CashierThread> cashierThreads = new ArrayList<>(customers.size());
        for (var listOfItems : customers) {
            cashierThreads.add(new CashierThread(new Random().nextInt(21), listOfItems));
        }
        return cashierThreads;
    }
}
