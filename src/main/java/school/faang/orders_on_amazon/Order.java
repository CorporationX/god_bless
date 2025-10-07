package school.faang.orders_on_amazon;

import lombok.*;

/**
 * Проект: god_bless
 * Класс Order
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Order {
    private final int id;

    @NonNull
    private OrderStatus status;
}