package faang.school.godbless.Walmart.Queue;


public class CashierThread extends Thread {

    private int cashierId;
    private Item[] customerItems;
    private int itemCount = 0;
    private int totalPrice = 0;

    public CashierThread(int cashierId, Item[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {

        for (Item item : customerItems) {
            System.out.println("Касса № " + cashierId + " :" + item.getName() + " пииип");
            itemCount++;
            totalPrice += item.getPrice();
        }
        System.out.println("Касса № " + cashierId + " : " + "itemCount = " + itemCount + " totalPrice = " + totalPrice);

    }

    public void printInfo() {
        System.out.println("Касса № " + cashierId + " : " + "itemCount = " + itemCount + " totalPrice = " + totalPrice);
    }
}
