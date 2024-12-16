package school.faang.task47728;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<Map<String, Integer>> customers = new ArrayList<>(List.of(
                new HashMap<>(
                        Map.of("игрушка", 250,
                                "молоко", 60,
                                "колбаса", 100)),
                new HashMap<>(
                        Map.of("пирог", 130,
                                "молоко", 60,
                                "мясо", 300)),
                new HashMap<>(
                        Map.of("масло", 290,
                                "колбаса", 100)),
                new HashMap<>(
                        Map.of("йогурт", 60,
                                "мороженое", 100))

        ));

        List<CashierThread> cashierThreads = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, customers.size()).forEach(i -> {
            int cashierId = random.nextInt(customers.size());

            CashierThread thread = new CashierThread(cashierId, customers.get(i));
            thread.start();
            cashierThreads.add(thread);
        });

        cashierThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        });


    }
}
