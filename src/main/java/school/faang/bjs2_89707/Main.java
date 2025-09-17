package school.faang.bjs2_89707;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int NUM_OF_CASHIERS = 3;
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Integer[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };
        List<CashierThread> cashiers = new ArrayList<>();

        for (int i = 0; i < NUM_OF_CASHIERS; i++) {
            cashiers.add(new CashierThread(i));
        }

        Arrays.stream(customers).forEach(customer -> {
            int cashierId = random.nextInt(NUM_OF_CASHIERS);
            cashiers.get(cashierId).addCustomer(customer);
        });

        cashiers.forEach(Thread::start);

        cashiers.forEach(cashierThread -> {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        log.info("All cashiers have completed their work");
    }
}

