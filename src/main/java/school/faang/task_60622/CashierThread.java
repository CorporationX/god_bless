package school.faang.task_60622;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread{
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        Arrays.asList(customerItems).forEach(item -> {
            System.out.printf("Casheir%d scans item: %d\n", cashierId, item);
        });
    }
}
