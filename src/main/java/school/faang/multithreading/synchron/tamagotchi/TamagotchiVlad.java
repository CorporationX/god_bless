package school.faang.multithreading.synchron.tamagotchi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TamagotchiVlad {
    private String name;
    private String state;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.state = "";
    }

    public synchronized void feed() {
        state = "сыт";
        log.info("{} ест, состояние {}", name, state);
    }

    public synchronized void play() {
        state = "весел";
        log.info("{} играет, состояние {}", name, state);
    }

    public synchronized void clean() {
        state = "чист";
        log.info("Чистим {}, состояние {}", name, state);
    }

    public synchronized void sleep() {
        state = "устал";
        log.info("{} спит, состояние {}", name, state);
    }
}
