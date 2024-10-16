package school.faang.BigBang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;


    @Override
    public void run() {
        System.out.println(name + " : " + task + " started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Task has been interrupted");
        }
        System.out.println(name + " : " + task + " finished");
    }
}
