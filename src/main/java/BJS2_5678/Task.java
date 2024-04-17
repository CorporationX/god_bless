package BJS2_5678;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " do " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong..");
        }
        System.out.println(name + " finished " + task);
    }
}
