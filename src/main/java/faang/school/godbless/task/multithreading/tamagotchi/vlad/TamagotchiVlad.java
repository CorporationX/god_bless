package faang.school.godbless.task.multithreading.tamagotchi.vlad;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class TamagotchiVlad {
    private static final Double DEFAULT_STATS = 10.;

    private final long id;
    private final String name;
    private Double hunger;
    private Double boring;
    private Double pollution;
    private Double energy;

    public TamagotchiVlad(long id, String name) {
        this.id = id;
        this.name = name;
        this.hunger = DEFAULT_STATS;
        this.boring = DEFAULT_STATS;
        this.pollution = DEFAULT_STATS;
        this.energy = DEFAULT_STATS;
    }

    public synchronized void feed() {
        if (hunger > 0) {
            hunger--;
            log.info("Feeding, {} hunger {}", name, hunger);
        } else {
            log.info("{} it's already feed up", name);
        }
    }

    public synchronized void play() {
        if (boring > 0) {
            boring--;
            log.info("Playing, {} boring {}", name, boring);
        } else {
            log.info("{} it's don't wont play now", name);
        }
    }

    public synchronized void clean() {
        if (pollution > 0) {
            pollution--;
            log.info("Cleaning, {} pollution {}", name, pollution);
        } else {
            log.info("{} it's already clean", name);
        }
    }

    public synchronized void sleep() {
        if (energy > 0) {
            energy--;
            log.info("Sleeping, {} energy {}", name, energy);
        } else {
            log.info("{} it's don't want sleep now", name);
        }
    }
}
