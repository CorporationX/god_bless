package school.faang.sprint1.task_47747;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {
                {10, 20, 30},
                {50, 60},
                {5, 15, 25, 35}
        };
        int numberOfCashiers = 3;
        CashierThread[] cashiers = new CashierThread[numberOfCashiers];
        Random random = new Random();
        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(numberOfCashiers);
            cashiers[cashierId] = new CashierThread(cashierId, customers[i]);
            cashiers[cashierId].start();
        }
        for (int i = 0; i < cashiers.length; i++) {
            try {
                cashiers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все покупатели обслужены.");
    }
}
