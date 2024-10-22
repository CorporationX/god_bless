package school.faang.sprint_4.bjs2_38638_wow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

@Slf4j
@Getter
public class Player {
    private static final int MAX_QUESTS_AT_TIME = 2;
    private static final int EXP_TO_LEVEL = 500;
    private final String name;
    private int level;
    private int exp;
    private final Semaphore semaphore;

    public Player(String name) {
        this.name = name;
        level = 1;
        exp = 0;
        semaphore = new Semaphore(MAX_QUESTS_AT_TIME);
    }

    public void addExperience(int exp) {
        if (exp + this.exp < EXP_TO_LEVEL) {
            this.exp += exp;
        } else {
            level++;
            this.exp = this.exp + exp - EXP_TO_LEVEL;
            log.info("{} GZ WITH NEW LEVEL {}! You have {} exp.", name, level, this.exp);
        }
    }
}
