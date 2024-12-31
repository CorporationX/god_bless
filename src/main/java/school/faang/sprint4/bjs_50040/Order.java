package school.faang.sprint4.bjs_50040;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private int idOrder;
    @Setter
    private OrderStatus status;

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", status=" + status + '}';
    }
}
