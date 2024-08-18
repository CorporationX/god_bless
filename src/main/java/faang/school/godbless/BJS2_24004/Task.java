package faang.school.godbless.BJS2_24004;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String namePerformer;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s начал выполнять задачу: %s%n", namePerformer, task);

        try {
            Thread.sleep(new Random().nextLong(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s закончил делать задачу: %s%n", namePerformer, task);
    }
}
