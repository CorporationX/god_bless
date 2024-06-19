package faang.school.godbless.domain.task_Big_Bang_Theory;

import java.util.Random;

public record Task(String name, String task) implements Runnable {

    public void run() {
        System.out.println("начало задания : " + task);
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            System.out.println(name + ": задание прервано");
            Thread.currentThread().interrupt();
        }
        System.out.println(name + ": задание выполнено");

    }
}
