package school.faang.queue_to_walmart_BJS2_36250;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    @Override
    public void run() {
        for (String item : customerItems) {
            System.out.printf("Cashier %d scan item: %s\n", cashierId, item);
        }
    }

}
