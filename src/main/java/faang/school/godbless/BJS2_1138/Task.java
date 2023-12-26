package faang.school.godbless.BJS2_1138;

import java.util.random.RandomGenerator;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " начал выполнять " + task);
        try {
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Задача " + task + " прервана");
        }
        System.out.println("задача " + task + " выполнена");
    }
}

