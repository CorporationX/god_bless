package faang.school.godbless.big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started task:%s\n", name, task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("task was interrupted");
            return;
        }
        System.out.printf("%s is completed\n", task);
    }
}
