package faang.school.godbless.multithreading.bigbang;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable{

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("> " + name + " started " + task);

        try {
            Thread.sleep(new Random().nextInt(4000));

            System.out.println("> " + name + " finished " + task);
        } catch (InterruptedException e) {
            System.out.println("> " + task + " canceled");

            throw new RuntimeException(e);
        }
    }

}
