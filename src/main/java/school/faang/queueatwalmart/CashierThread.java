package school.faang.queueatwalmart;

import lombok.AllArgsConstructor;
import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
}
