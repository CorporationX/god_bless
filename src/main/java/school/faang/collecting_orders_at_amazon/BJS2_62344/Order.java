package school.faang.collecting_orders_at_amazon.BJS2_62344;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {
    private final UUID id;
    private Status status;

    public Order(Status status) {
        this.id = UUID.randomUUID();
        this.status = status;
    }
}
