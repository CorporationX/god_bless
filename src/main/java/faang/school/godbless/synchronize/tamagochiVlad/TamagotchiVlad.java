package faang.school.godbless.synchronize.tamagochiVlad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class TamagotchiVlad {
    private String name;

    public synchronized void feed() {
        try {
            System.out.println("Feeding " + name);
            TimeUnit.SECONDS.sleep(3);
            super.notify();
            System.out.println(name + " was fed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void play() {
        try {
            System.out.println("Playing " + name);
            TimeUnit.SECONDS.sleep(4);
            super.notify();
            System.out.println(name + " played");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void sleep() {
        try {
            System.out.println(name + " is sleeping");
            TimeUnit.SECONDS.sleep(6);
            super.notify();
            System.out.println(name + " waken up");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void clean() {
        System.out.println(name + " is cleaning");
    }

    public static final class Factory {
        private static final String NAME_TEMPLATE = "Tamagotchi %d";
        private static int nextIndex = 1;

        public static TamagotchiVlad create() {
            return new TamagotchiVlad(String.format(NAME_TEMPLATE, nextIndex++));
        }
    }
}
