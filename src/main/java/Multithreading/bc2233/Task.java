package Multithreading.bc2233;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println("Задание " + getTask() + " начало выполнятся");
            Thread.sleep(3000);
            System.out.println("Задание " + getTask() + " выполнено");
        } catch (InterruptedException e) {
            System.out.println("Задание прервано");
            throw new RuntimeException(e);
        }
    }
}
