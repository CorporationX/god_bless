package faang.school.godbless.WallmartQueue;

public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    public CashierThread(int cashierId, String[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (String item : this.customerItems) {
            System.out.println(item + " proceeded by cashier with id " + this.cashierId);
        }
    }
}
