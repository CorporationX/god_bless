package school.faang.sprint_4.task_49981;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public final class Player {
    private final @NonNull String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int reward) {
        experience += reward;
    }

    public synchronized int getExperience() {
        return experience;
    }
}
