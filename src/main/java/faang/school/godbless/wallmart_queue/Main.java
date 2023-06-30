package faang.school.godbless.wallmart_queue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        List<CashierThread> cashiers = new ArrayList<>(customers.length);

        for(int i = 0; i < customers.length; i++){
            CashierThread thread = new CashierThread(i + 1, customers[i]);
            cashiers.add(thread);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tasks finished");
    }
}
