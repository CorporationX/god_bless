package bjs2_37874;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private String status;

    public Order(int id) {
        this.id = id;
        status = "Processing";
    }
}
