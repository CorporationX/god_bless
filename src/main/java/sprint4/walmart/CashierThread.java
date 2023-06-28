package sprint4.walmart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CashierThread extends Thread {
    private static int totalSells = 0;
    private static int totalProfit = 0;
    private long cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        System.out.printf("Cashier %d began to serve customer\n", cashierId);
        for (int item : customerItems) {
            System.out.printf("Cashier %d processes item with price %d\n", cashierId, item);
            processesItem(item);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
        }
        System.out.printf("Cashier %d is waiting for next customer\n\n", cashierId);
    }

    private synchronized void processesItem(int item) {
        totalSells++;
        totalProfit += item;
    }

    public static void resetCounters() {
        totalSells = 0;
        totalProfit = 0;
    }

    public static int getTotalSells() {
        return totalSells;
    }

    public static int getTotalProfit() {
        return totalProfit;
    }
}
