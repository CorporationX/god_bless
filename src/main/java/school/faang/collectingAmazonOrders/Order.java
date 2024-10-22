package school.faang.collectingAmazonOrders;

import lombok.Data;

@Data
public class Order {

    private final int id;
    private Statuses status;

    public Order(int id, Statuses status) {
        this.id = id;
        this.status = status;
    }

    public boolean checkIfOrdered() {
        return status.equals(Statuses.ORDERED);
    }
}