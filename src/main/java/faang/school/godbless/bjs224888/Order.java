package faang.school.godbless.bjs224888;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "new";
    }
}