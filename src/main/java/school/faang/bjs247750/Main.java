package school.faang.bjs247750;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Map<String, Integer>> customers = new ArrayList<>(List.of(
                new HashMap<>(
                        Map.of("book", 250, "kefir", 60, "cheese", 100)),
                new HashMap<>(
                        Map.of("pie", 130, "milk", 60, "meet", 300)),
                new HashMap<>(
                        Map.of("butter", 290, "pensil", 100)),
                new HashMap<>(
                        Map.of("cheese", 60, "pen", 100))
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
                Thread.currentThread().interrupt();
                log.error("The thread was interrupted while waiting for the thread to complete {}", e.getMessage());
            }
        });
    }
}
