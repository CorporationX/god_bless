package school.faang.wow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Player {
    private final String name;
    private int experience;

    public Player(String name) {
        this.name = name;
        experience = 0;
    }

    public synchronized void addExp(int exp) {
        experience += exp;
    }
}
