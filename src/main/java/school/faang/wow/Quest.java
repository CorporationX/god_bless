package school.faang.wow;

import lombok.Data;

@Data
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}