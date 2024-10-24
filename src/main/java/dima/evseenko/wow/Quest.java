package dima.evseenko.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private Difficulty difficulty;
    private int reward;
}
