package faang.school.godbless.sprint4.amazon_orders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Order {
    private final long id;
    @Setter
    private Status status = Status.NEW;
}
