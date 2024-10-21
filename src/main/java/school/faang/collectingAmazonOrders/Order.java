package school.faang.collectingAmazonOrders;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private static final List<String> VALID_STATUSES = List.of("Ordered", "Ready");

    private final int id;
    private String status;

    public Order(int id, String status) {
        if (!VALID_STATUSES.contains(status)) {
            throw new IllegalArgumentException("Invalid order status. Valid statuses - Ordered/Ready");
        }
        this.id = id;
        this.status = status;
    }

    public boolean checkIfOrdered() {
        return status.equals("Ordered");
    }
}
