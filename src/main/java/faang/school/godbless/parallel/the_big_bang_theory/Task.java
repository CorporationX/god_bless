package faang.school.godbless.parallel.the_big_bang_theory;

import lombok.Data;

import java.util.Random;

@Data
public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s начинает выполнение задачи \"%s\"\n", name, task);
        try {
            Thread.sleep((new Random().nextInt(0,5))*1000);
        } catch (InterruptedException e) {
            System.out.printf("Задача \"%s\" прервана\n", task);
            e.printStackTrace();
        }

        System.out.printf("Задача \"%s\" успешно выполнена.\n", task);
    }
}
