package school.faang.bjs2_92608;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final Difficult difficult;
    private final int reward;
}
