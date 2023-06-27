package faang.school.godbless.WallmartLine;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public static void main(String[] args) {
        int[][] customers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            CashierThread cashierThread = new CashierThread(i, customers[i]);
            cashiers[i] = cashierThread;
        }
        ExecutorService service = Executors.newFixedThreadPool(customers.length);
        for (CashierThread cashierThread : cashiers) {
            service.execute(cashierThread);
        }
        service.shutdown();
    }

    @Override
    public void run() {
        int sum = 0;
        for (int customerItem : customerItems) {
            try {
                System.out.println("Good number: " + customerItem + " is paid");
                Thread.sleep(100);
                sum += customerItem;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Revenue by cash named: " + Thread.currentThread().getName() + " is: " + sum);
    }
}
