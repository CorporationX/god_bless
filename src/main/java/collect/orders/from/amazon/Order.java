package collect.orders.from.amazon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {
    private final long id = System.nanoTime();
    private Status status = Status.NEW;
}
