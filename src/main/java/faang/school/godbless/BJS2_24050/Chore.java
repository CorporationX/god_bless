package faang.school.godbless.BJS2_24050;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread()
                .getName()
                .substring(7);
        System.out.printf("Волшебный поток %s выполняет задачу: %s%n", currentThreadName, name);

        try {
            Thread.sleep(new Random().nextLong(1_000, 10_000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Волшебный поток %s закончил задачу: %s%n", currentThreadName, name);
    }
}
