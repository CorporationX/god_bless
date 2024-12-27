package school.faang.task_50111;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class Order {

    private int id;
    private OrderStatus status;

    public Order(int id, OrderStatus status) {
        if (id <= 0 || status == null) {
            log.error("id or status not valid");
            throw new IllegalArgumentException("id or status not valid");
        }
        this.id = id;
        this.status = status;
    }

    private static final Map<OrderStatus, List<OrderStatus>> VALID_TRANSIT_STATUS = Map.of(
            OrderStatus.New, List.of(OrderStatus.InProcess),
            OrderStatus.InProcess, List.of(OrderStatus.Completed, OrderStatus.Cancelled)
    );

    public synchronized void setStatus(OrderStatus newStatus) throws IllegalStateException {
        List<OrderStatus> validStatus = VALID_TRANSIT_STATUS.getOrDefault(this.status, List.of());

        if (!validStatus.contains(newStatus)) {
            log.error("Ошибка в заказе id: {}. Невозможно изменить статус заказа с {} на {}", id, status, newStatus);
            throw new IllegalStateException();
        }
        this.status = newStatus;
    }
}