package faang.school.godbless.sprint3.walmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        int[] cashiers = {1, 2, 3, 4};

        List<CashierThread> cashierThreadList = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < customers[i].length; j++) {
                CashierThread cashier = new CashierThread(cashiers[i], customers[i][j]);
                cashierThreadList.add(cashier);
            }
        }
        for(CashierThread cashier : cashierThreadList){
            cashier.start();
        }
    }
}
