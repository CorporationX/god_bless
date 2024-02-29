package faang.school.godbless.multithreading_async.wizards;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
