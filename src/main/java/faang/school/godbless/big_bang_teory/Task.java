package faang.school.godbless.big_bang_teory;

import lombok.Data;

@Data
public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(getName() + " начал выполнять своё задание");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задание " + getTask() + " закончено Выполнил: " + getName());
    }
}

