package school.faang.task316.task;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(String.format("%s Начинает выполнять задачу %S", name, task));
            Thread.sleep((new Random().nextInt(5) + 1) * 1000);
            System.out.println(String.format("%s завершает задачу %S", name, task));

        } catch (InterruptedException e) {
            System.out.println(String.format("%s Не смог завершить задачу %S", name, task));
        }
    }
}
