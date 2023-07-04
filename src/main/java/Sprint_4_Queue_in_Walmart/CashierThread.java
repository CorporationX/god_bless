package Sprint_4_Queue_in_Walmart;

public class CashierThread extends Thread {
    private int cashierId;
    //число кассиров 3, меньше, чем число покупателей (4)
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public void run() {
        int sumItems = 0;
        int sumI = 0;
        for (int i = 0; i < customerItems.length; i++) {
            sumItems += customerItems[i];
            sumI +=1;
        }
        System.out.println("Cashier: " + cashierId + " пробивает товары покупателя: "
                + Thread.currentThread().getName() +" сумма покупок: "+ sumItems + ", колличество покупок: " + sumI);
    }

    public static void main(String[] args) {
        int[][] customersBaskets = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        CashierThread[] allCustomers = new CashierThread[customersBaskets.length];

        for (int i = 0; i < customersBaskets.length; i++) {
            allCustomers[i] = new CashierThread((int) (Math.random() * 3) + 1, customersBaskets[i]);
        }

        for (int i = 0; i < allCustomers.length; i++) {
            allCustomers[i].start();
        }
    }
}

