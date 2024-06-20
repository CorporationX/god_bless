package faang.school.godbless.bigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    public void run() {
        System.out.println(name + " начал выполнять: " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задание " + task + " исполнителя " + name + " было прервано.");
            throw new RuntimeException(e);
        }
        System.out.println(name + " выполнил: " + task);
    }
}
