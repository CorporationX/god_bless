package school.faang.task_50201;

import lombok.Getter;

@Getter
public class Order {
    private final int id;
    private String status = "New";

    public Order(int id, String status) {
        if (status.isEmpty()) {
            throw new IllegalArgumentException("The Status cannot be empty");
        }
        this.id = id;
        this.status = status;
    }

    public void orderDone() {
        status = "Done";
    }
}
