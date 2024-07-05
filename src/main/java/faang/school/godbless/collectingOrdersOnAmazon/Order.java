package faang.school.godbless.collectingOrdersOnAmazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private Status status;

    public synchronized void setStatus(Status status) {
        this.status = status;
    }
    public synchronized Status getStatus() {
        return status;
    }
}
