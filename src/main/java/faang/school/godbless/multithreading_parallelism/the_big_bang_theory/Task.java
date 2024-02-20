package faang.school.godbless.multithreading_parallelism.the_big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;
    private static Random random = new Random();

    @Override
    public void run() {
        System.out.println(String.format("Начинаю выполнять задачу %s", task));
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Выполнил задачу %s",task));
    }
}
