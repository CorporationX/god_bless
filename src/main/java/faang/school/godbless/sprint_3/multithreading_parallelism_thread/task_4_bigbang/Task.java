package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_4_bigbang;

import java.util.Random;

public record Task(String name, String task) implements Runnable{
    private static final String MSG_ERROR = "Работа прервана";

    @Override
    public void run() {
        try {
            System.out.println(name + ": " + task);
            Thread.sleep(new Random().nextInt(3000, 7000));
            System.out.println(name + ": задачу выполнил.");
        } catch (InterruptedException e) {
            System.out.println(MSG_ERROR);
        }
    }
}
