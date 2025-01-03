package school.faang.bjs251634.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
