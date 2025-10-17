package school.faang.bjs2_92813;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Task {
    private String name;
    @Getter
    private int difficulty;
    @Getter
    private int reward;
}
