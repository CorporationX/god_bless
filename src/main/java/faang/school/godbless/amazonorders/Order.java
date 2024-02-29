package faang.school.godbless.amazonorders;

import lombok.Data;

@Data
public class Order {

    private long id;
    private boolean isProcessed;

    public Order(long id) {
        this.id = id;
    }
}
