package Sprint_4_Task7;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < customerItems.length; i++) {
            System.out.println("Cashier " + cashierId + " got item " + customerItems[i]);
            sum += customerItems[i];

        }
        System.out.println("Cashier " + cashierId + " finished " + "Sum = " + sum);
    }

    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            CashierThread cashier = new CashierThread(i, customers[i]);
            cashiers[i] = cashier;
        }
        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
