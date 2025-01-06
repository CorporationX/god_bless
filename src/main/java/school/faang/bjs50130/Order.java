package school.faang.bjs50130;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private boolean isProcessed;

    public Order(int id) {
        this.id = id;
        isProcessed = false;
    }
}
