package faang.school.multithreadingparallelismthread.thebigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Начал выполнение задачи!");

        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Задача выполнена успешно!");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Задача была прервана!");
        }
    }
}
