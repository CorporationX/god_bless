package faang.school.godbless.queue_at_walmart;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};

        List<CashierThread> cashiers = new ArrayList<>(customers.length);

        for (int i = 0; i < customers.length; i++) {
            CashierThread cashierThread = new CashierThread(i, customers[i]);
            cashiers.add(cashierThread);
            cashierThread.start();

            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All customers are served");
    }
}
