package faang.school.godbless.Walmart;

import lombok.Data;

import java.util.Random;

@Data
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    public CashierThread(int cashierId, String[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int count = 0;
        int sum = 0;
        for (String item : customerItems) {
            System.out.println("+" + item);
            count++;
            sum += new Random().nextInt(100) + 20;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cashier " + cashierId + ": " + count + " товаров на сумму " + sum);
    }
}
