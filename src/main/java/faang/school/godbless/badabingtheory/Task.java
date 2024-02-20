package faang.school.godbless.badabingtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(String.format("Task \"%s\" started", task));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(String.format("Task \"%s\" interrupted", task));
            return;
        }
        System.out.println(String.format("Task \"%s\" completed", task));
    }
}
