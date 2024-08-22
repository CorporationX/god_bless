package faang.school.godbless.BJS2_24279;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + "started his task");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Task is interrupted");
            e.printStackTrace();
        }
        System.out.println(name + " completed his task");
    }
}
