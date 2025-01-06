package school.faang.task_50179;

import lombok.Data;

@Data
public class Order {
    private int id;
    private Status status;

    public Order(int id, Status status) {
        this.id = id;
        this.status = status;
    }
}
