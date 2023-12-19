package faang.school.godbless.parallelism.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started %s\n", name, task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.interrupted();
            System.out.printf("%s interrupted\n", name);
        }
    }

}
