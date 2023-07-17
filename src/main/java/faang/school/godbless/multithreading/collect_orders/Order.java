package faang.school.godbless.multithreading.collect_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private Status status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
