package faang.school.godbless.async.task_3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void addExperience(int points) {
        experience += points;
    }
}