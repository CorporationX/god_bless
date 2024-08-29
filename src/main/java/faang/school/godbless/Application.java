package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        int[][] customer = {
                {100, 200, 300},
                {50, 50, 50, 100},
                {200, 300},
                {400, 150, 100, 50}
        };

        CashierThread[] cashiers = new CashierThread[customer.length];

        for (int i = 0; i < customer.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customer[i]);
        }

        for(CashierThread cashier : cashiers){
            cashier.start();
        }

        for (CashierThread cashier : cashiers){
            try {
                cashier.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
