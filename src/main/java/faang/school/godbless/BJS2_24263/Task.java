package faang.school.godbless.BJS2_24263;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started doing task '" + task + "'");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("The task was interrupted");
            throw new RuntimeException(e);
        }
        System.out.println("The task '" + task + "' was completed");
    }
}
