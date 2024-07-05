package WOW;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
