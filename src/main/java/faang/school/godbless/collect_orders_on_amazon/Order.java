package faang.school.godbless.collect_orders_on_amazon;

import lombok.Data;

@Data
public class Order {
    private static int startId = 0;
    private int id;
    private Status status;

    public Order() {
        this.id = startId++;
        this.status = Status.ON_PROCESS;
    }
}