package faang.school.multithreadingparallelismthread.thetriwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
