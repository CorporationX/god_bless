package faang.school.multithreadingparallelismthread.thebigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    private static final long MILLIS_SLEEP_THREAD = 1000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Начал выполнение задачи!");

        try {
            Thread.sleep(MILLIS_SLEEP_THREAD);
            System.out.println(Thread.currentThread().getName() + " Задача выполнена успешно!");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Задача была прервана!");
        }
    }
}
