package faang.school.godbless.TamagochiVlad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TamagochiVlad {
    private String name;

    public synchronized void feed() {
        System.out.printf("Tamagochi %s was fed %n", name);
    }

    public synchronized void play() {
        System.out.printf("Tamagochi %s is playing %n", name);
    }

    public synchronized void clean() {
        System.out.printf("Tamagochi %s was cleaned %n", name);
    }

    public synchronized void sleep() {
        System.out.printf("Tamagochi %s is sleeping %n", name);
    }
}
