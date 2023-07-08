package faang.school.godbless.TamagotchiVlad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TamagotchiVlad {
    private int id;
    private AtomicInteger happiness;
    private AtomicInteger cleanness;

    public TamagotchiVlad(int id) {
        this.id = id;
        this.happiness = new AtomicInteger(0);
        this.cleanness = new AtomicInteger(0);
    }

    public synchronized void feed() {
        happiness.incrementAndGet();
        System.out.println("Tamagotchi with id " + id + " is eating | Happiness: " + happiness.get());
    }

    public synchronized void play() {
        happiness.incrementAndGet();
        System.out.println("Tamagotchi with id " + id + " is playing | Happiness: " + happiness.get());
    }

    public synchronized void clean() {
        cleanness.incrementAndGet();
        System.out.println("Tamagotchi with id " + id + " has been cleaned | Cleanness: " + cleanness.get());
    }

    public synchronized void sleep() {
        happiness.incrementAndGet();
        System.out.println("Tamagotchi with id " + id + " is sleeping | Happiness: " + happiness.get());
    }

}
