package school.faang.bjs2_74824;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

    private final String name;
    private final int difficulty;
    private final int reward;
}
