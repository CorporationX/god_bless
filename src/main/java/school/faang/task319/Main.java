package school.faang.task319;

import school.faang.task319.cashier.CashierThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[][] customers = new String[][]{
                {"carrot", "milk", "water", "bread", "meet"}
                , {"snickers", "mars", "potato"}
                , {"соса-cola"}
                , {"Strawberry", "bread"}};

        CashierThread[] cashier = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashier[i] = new CashierThread(i, customers[i]);
        }
        for(CashierThread thread : cashier){
            thread.start();
        }
        for (CashierThread thread : cashier){
            thread.join();
        }
    }
}
