package faang.school.godbless.amazon;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Order {
    private final int id;
    private Status status = Status.CREATED;
}
