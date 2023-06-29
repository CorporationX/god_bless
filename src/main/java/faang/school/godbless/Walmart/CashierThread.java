package faang.school.godbless.Walmart;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Integer> customerItems;

    @SneakyThrows
    @Override
    public void run() {
        int totalCost = customerItems.stream().reduce(0, Integer::sum);
        System.out.println("Cashier " + cashierId + " starts");
        Thread.sleep(new Random().nextInt(1000, 5000));
        System.out.println("Cashier " + cashierId + " total cost: $" + totalCost);
    }
}
