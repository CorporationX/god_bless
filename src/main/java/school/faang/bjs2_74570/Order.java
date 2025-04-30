package school.faang.bjs2_74570;

import lombok.Data;

@Data
public class Order {

    private final int id;
    private String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
