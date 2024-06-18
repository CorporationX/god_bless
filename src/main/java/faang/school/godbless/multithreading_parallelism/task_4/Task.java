package faang.school.godbless.multithreading_parallelism.task_4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private static final int PROGRESS_TIME = 5000;

    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.println(name + " начинает работу над заданием: " + task);
        try {
            Thread.sleep(PROGRESS_TIME);
        } catch (InterruptedException e) {
            System.out.println("Произошла ошибка " + e + " у " + name + " при работе над заданием: " + task);
        }
        System.out.println(name + " закончил работу над заданием: " + task);
    }

}
