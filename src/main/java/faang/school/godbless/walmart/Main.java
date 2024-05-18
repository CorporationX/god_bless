package faang.school.godbless.walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};

        List<CashierThread> list = new ArrayList<>(customers.length);
        for (int i = 0; i < customers.length; i++) {
            list.add(new CashierThread(i, customers[i]));
        }

        for (CashierThread cashier : list) {
            Thread.sleep(2000);
            cashier.start();
        }
    }
}
