package faang.school.godbless.tamagotchi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TamagotchiVlad {
    private String name;

    public synchronized void feed() {
        System.out.println(name + " кушает");
    }

    public synchronized void play() {
        System.out.println(name + " развлекается");
    }

    public synchronized void clean() {
        System.out.println(name + " моется");
    }

    public synchronized void sleep() {
        System.out.println(name + " спит");
    }
}
