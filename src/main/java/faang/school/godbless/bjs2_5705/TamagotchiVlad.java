package faang.school.godbless.bjs2_5705;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TamagotchiVlad {

    private String name;

    public synchronized void feed() {
        log.info("{} is feeding", name);
    }

    public synchronized void play() {
        log.info("{} is playing", name);
    }

    public synchronized void clean() {
        log.info("{} is cleaning", name);
    }

    public synchronized void sleep() {
        log.info("{} is sleeping", name);
    }
}
