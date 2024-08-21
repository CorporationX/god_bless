package faang.school.godbless.sprint.three.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s perform the following task: %s%n", this.name, this.task);
        try {
            Thread.sleep(Constants.PERFORM_TASK);
            System.out.printf("Task: %s finished!%n", this.task);
        } catch (InterruptedException e) {
            System.out.printf("Task: %s interrupted! Because performed too long%n", this.task);
        }
    }
}
