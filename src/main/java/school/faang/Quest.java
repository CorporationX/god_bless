package school.faang;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
