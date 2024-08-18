package faang.school.godbless.BJS2_23980;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {

        try {
            System.out.printf("%s has started%n", this.task);
            Thread.sleep(3000);
            System.out.printf("%s has done%n", this.task);
        } catch (InterruptedException e) {
            System.out.println("Something has gone wrong");
            Thread.currentThread().interrupt();
        }
    }
}
