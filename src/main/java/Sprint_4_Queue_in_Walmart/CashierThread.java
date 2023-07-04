package Sprint_4_Queue_in_Walmart;
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + "Cashier " + "пробивает такие товары:" + cashierId);
    }

    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].start();
        }
    }
}

