package faang.school.godbless.multithreadingS4.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<List<String>> customers = List.of(
                fillItems(1),
                fillItems(2),
                fillItems(3)
        );

        List<Thread> cashiers = customers.stream().map(items -> new Thread(new CashierThread(items))).toList();

        cashiers.forEach(Thread::start);
        cashiers.forEach(thread -> {
            try{
                thread.join();
            } catch (InterruptedException e){
                System.out.printf("%s has been interrupted.%n", thread.getName());
                e.getStackTrace();
            }
        });

        System.out.println("All customers were served");

    }

    private static List<String> fillItems(int buyer) {
        int countItems = RANDOM.nextInt(20) + 1;
        List<String> items = new ArrayList<>(countItems);
        for (int i = 0; i < countItems; i++) {
            items.add(String.format("product %d:%d", buyer, i + 1));
        }
        return items;
    }
}
