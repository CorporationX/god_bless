package school.faang.amazon_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
    private final int id;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }
}
