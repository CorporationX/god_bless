package school.faang.sprint4.task_63222;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Donation {
    private static int idGenerator;
    private final int id = idGenerator++;
    @Getter
    private final double amount;
}
