package faang.school.godbless.task.multithreading.async.wow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private static final int EXPERIENCE_BY_LEVEL = 100;

    private final String name;
    private int experience = 0;

    public void addExp(int exp) {
        experience += exp;

    }

    public int getLevel() {
       return experience / EXPERIENCE_BY_LEVEL;
    }
}
