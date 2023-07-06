package faang.school.godbless.fourth.Amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final int id;
    private Status status;
}
