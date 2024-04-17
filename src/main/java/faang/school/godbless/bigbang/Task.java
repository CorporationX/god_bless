package faang.school.godbless.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println("Start of processing");
            Thread.sleep(2000);
            System.out.println(name + " has done " + task);
        } catch (InterruptedException e) {
            throw new RuntimeException("Processing has stopped");
        }
    }
}
