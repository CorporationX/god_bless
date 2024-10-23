package school.faang.asynchrony.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private Integer difficulty;
    private Integer reward;
}
