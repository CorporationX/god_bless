package school.faang.bjs2_74883;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int reward;
    private String name;
    private Difficulty difficulty;
}
