package queue_at_walmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;
    public CashierThread(int cashierId, int[] customerItems){
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }
    public void run(){
        int totalPrice = 0;
        for(var item: customerItems){
            totalPrice += item;
        }
        System.out.println("You have bought "+customerItems.length+" products for the amount of "+totalPrice);
    }

    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        Thread[] cashiers = new Thread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
        }

        try{
            for (var thread: cashiers){
                thread.join();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
