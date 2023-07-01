package faang.school.godbless.TamagotchiVlad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TamagotchiVlad {
    private int id;

    public synchronized void feed() {
        System.out.println("Tamagotchi with id " + id + " is eating");
    }

    public synchronized void play() {
        System.out.println("Tamagotchi with id " + id + " is playing");
    }

    public synchronized void clean() {
        System.out.println("Tamagotchi with id " + id + " has been cleaned");
    }

    public synchronized void sleep() {
        System.out.println("Tamagotchi with id " + id + " is sleeping");
    }

}
