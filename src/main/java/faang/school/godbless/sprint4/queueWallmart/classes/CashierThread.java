package faang.school.godbless.sprint4.queueWallmart.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int totalSum;
    private int countItems;

    @Override
    public void run() {
        Arrays.stream(customerItems)
                .forEach(item -> {
                    totalSum += item;
                    countItems++;
                });
    }
}