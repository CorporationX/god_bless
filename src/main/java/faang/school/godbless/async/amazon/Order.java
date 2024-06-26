package faang.school.godbless.async.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final long id;
    private String status;
}
