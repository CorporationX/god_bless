package faang.school.godbless.normalGame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String... args) throws InterruptedException {
        List<Thread> threads = List.of(
        new Pig1Thread(),
        new Pig2Thread(),
        new Pig3Thread()
        );
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Game Over!");

    }
}
