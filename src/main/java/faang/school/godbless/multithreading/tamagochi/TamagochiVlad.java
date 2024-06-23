package faang.school.godbless.multithreading.tamagochi;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class TamagochiVlad {
    @Getter
    private final String name;
    private boolean isSleeping = false;

    public TamagochiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed(String food) {
        System.out.println(name + " съел " + food);
    }

    public synchronized void play(String game) {
        System.out.println(name + " играет в " + game);
    }

    public synchronized void clean() {
        System.out.println(name + " очистился");
    }

    public synchronized void sleep() {
        isSleeping = true;
        System.out.println(name + " спит: " + isSleeping);
    }
}
