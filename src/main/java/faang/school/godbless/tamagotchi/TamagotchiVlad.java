package faang.school.godbless.tamagotchi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TamagotchiVlad {
    private static int startId = 0;
    private int id;
    private String name;

    public TamagotchiVlad(String name) {
        this.id = startId++;
        this.name = name;
    }

    public synchronized void feed() {
        log.info("Tamagotchi with name {} caled method 'feed'.", name);
    }

    public synchronized void play() {
        log.info("Tamagotchi with name {} caled method 'play'.", name);
    }

    public synchronized void clean() {
        log.info("Tamagotchi with name {} caled method 'clean'.", name);
    }

    public synchronized void sleep() {
        log.info("Tamagotchi with name {} caled method 'sleep'.", name);
    }
}