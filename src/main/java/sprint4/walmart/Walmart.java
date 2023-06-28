package sprint4.walmart;

public class Walmart {
    public static void main(String[] args) {
        int[][] customers = {{10,12,5,4}, {55,3,15,6,17,29}, {5,5,1,19,4}, {10,25,11}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        fillCashierArray(cashiers, customers);
        startWork(cashiers);

        System.out.printf("Total sells: %d\nTotal profit: %d", CashierThread.getTotalSells(),
                CashierThread.getTotalProfit());
    }

    private static void fillCashierArray(CashierThread[] cashiers, int[][] customers) {
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
        }
    }

    private static void startWork(CashierThread[] cashiers) {
        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
        }
    }
}
