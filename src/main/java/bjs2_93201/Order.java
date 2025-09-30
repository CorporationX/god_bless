package bjs2_93201;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
class Order {
    private final int id;
    private OrderStatus status;
}