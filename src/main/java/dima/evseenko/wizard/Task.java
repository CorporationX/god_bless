package dima.evseenko.wizard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private Difficulty difficulty;
    private int reward;
}
