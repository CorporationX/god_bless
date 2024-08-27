package faang.school.godbless.BJS2_24372;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private final Gender gender;
    private final Gender preference;
    private volatile Status status;
}