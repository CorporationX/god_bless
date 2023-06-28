package faang.school.godbless.multithreadingS4.walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class CashierThread extends Thread {
    private static final Random RANDOM = new Random();
    private static final int COEF_SLEEP = 10;
    private static AtomicInteger nextId = new AtomicInteger(0);

    @Getter
    private int cashierId;

    private List<String> customerItems;

    public CashierThread(List<String> items) {
        cashierId = nextId.getAndIncrement();
        customerItems = items;
    }

    @Override
    public void run() {
        for (String item : customerItems) {
            System.out.printf("Processed %s\n", item);

            try {
                Thread.sleep(RANDOM.nextInt(10) * COEF_SLEEP);
            } catch (InterruptedException e){
                System.out.printf("%s has been interrupted.\n", Thread.currentThread().getName());
                e.getStackTrace();
            }
        }
    }
}
