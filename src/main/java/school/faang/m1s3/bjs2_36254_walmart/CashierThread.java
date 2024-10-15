package school.faang.m1s3.bjs2_36254_walmart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int totalMoneyEarned;

    @Override
    public void run() {
        System.out.println("Starting the process:");

        int totalSum = 0;
        for (int i = 0; i < customerItems.length; i++) {
            System.out.printf("The price of product #%d is $%d%n", i + 1, customerItems[i]);
            totalSum += customerItems[i];
            System.out.println("Total amount is $" + totalSum);
            System.out.println();
        }
        totalMoneyEarned += totalSum;
    }
}
