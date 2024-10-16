package school.faang.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private static final int TIME_FOR_TASK = 100;

    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " начал выполнять задачу - " + task);
            Thread.sleep(TIME_FOR_TASK);
            System.out.println(name + " выполнил задачу - " + task);
        } catch (InterruptedException e) {
            System.out.println("Задача " + task + " прервана");
        }
    }
}