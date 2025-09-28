package school.faang.bjs2_92621;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Quest {

    private final String name;
    private final int difficulty;
    private final int reward;
}
