package faang.school.godbless.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CashierThread extends Thread {
     private int cashierId;
     private int[] customerItems;

    @Override
    public void run() {
        try {
            System.out.println("Cashier " + cashierId + " is serving customer...");
            TimeUnit.SECONDS.sleep(3);
            int sum = IntStream.of(customerItems).reduce(0, Integer::sum);
            System.out.println("Cashier " + cashierId + " has " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
