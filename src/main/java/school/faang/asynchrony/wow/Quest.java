package school.faang.asynchrony.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private Integer difficulty;
    private Integer reward;
}
