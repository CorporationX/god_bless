package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class PurchaseProcessing {
    public static void main(String[] args) {
        int[][] customers = {
                {5, 7, 3, 2, 4, 2, 5, 3, 9, 3, 4, 3, 5, 2, 3},
                {1, 2, 3, 5, 7, 3, 2, 4, 2, 5, 1, 5, 9, 9, 2},
                {6, 5, 2, 4, 2, 5, 1, 5, 9, 7, 2, 4, 7, 1, 2},
                {10, 2, 1, 3, 5, 6, 5, 2, 4, 2, 5, 1, 5, 9,1}
        };
        List<CashierThread> cashiers = new ArrayList<>(customers.length);

        for(int i = 0; i< customers.length; i++){
            CashierThread cashierThread = new CashierThread(i, customers[i]);
            cashiers.add(cashierThread);
            cashierThread.start();
        }

        for (Thread thread: cashiers){
            try{
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
