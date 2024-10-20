package school.faang.multithreading.asynchronism.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
