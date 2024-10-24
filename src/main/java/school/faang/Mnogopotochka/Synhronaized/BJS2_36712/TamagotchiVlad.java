package school.faang.Mnogopotochka.Synhronaized.BJS2_36712;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class TamagotchiVlad {
    private static final Logger log = LoggerFactory.getLogger(TamagotchiVlad.class);
    private final Object lock = new Object();
    private String name;
    private String state;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.state = "neutral";
    }

    public synchronized void feed() {
        state = "full";
        log.info("{} eat, current state: {}", getName(), state);
    }

    public synchronized void play() {
        state = "playing";
        log.info("{} play, current state: {}", getName(), state);
    }

    public synchronized void clean() {
        state = "clean";
        log.info("{} clean, current state: {}", getName(), state);
    }

    public synchronized void sleep() {
        state = "sleeping";
        log.info("{} sleep, current state: {}", getName(), state);
    }
}
