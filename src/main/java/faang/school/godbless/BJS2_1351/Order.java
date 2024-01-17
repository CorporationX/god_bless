package faang.school.godbless.BJS2_1351;

import lombok.Data;

@Data
public class Order {
    private static int count;
    private int id;
    private boolean isProcessed;

    public Order() {
        this.id = ++count;
        this.isProcessed = false;
    }
}