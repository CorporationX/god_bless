package faang.school.godbless.thread.bigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s начал задание %s\n", name, task);
            TimeUnit.SECONDS.sleep(new Random().nextInt(1, 30));
            System.out.printf("%s закончил задание %s\n", name, task);
        } catch (InterruptedException e) {
            System.out.println("Задание прервано!" + name);
        }
    }
}
