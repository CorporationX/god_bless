package school.faang.task_50179;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
