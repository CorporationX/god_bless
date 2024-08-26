package faang.school.godbless.BJS2_24800;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {
    private final int id;
    private Status status = Status.WAITING;
}
