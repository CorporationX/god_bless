package Queue_at_Walmart;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;
    private int numberOfItems;
    private int totalCost;

    public int getCashierId() {
        return cashierId;
    }

    public int[] getCustomerItems() {
        return customerItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (int item : customerItems) {
            totalCost += item;
            numberOfItems++;
        }
    }
}
