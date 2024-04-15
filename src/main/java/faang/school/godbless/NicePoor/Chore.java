package faang.school.godbless.NicePoor;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final Random random = new Random();

    @Override
    public void run() {
        System.out.println(chore + " выполняется в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println(chore + " - не выполнено");
            return;
        }
        System.out.println(chore + " - выполнено");
    }
}
