package school.faang.m1.thread.supercow;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        Thread[] threads = IntStream.range(0, 4)
                .mapToObj(i -> new Thread(() -> new Player("P" + i).doBattle(boss)))
                .toArray(Thread[]::new);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
