package school.faang.bjs249007;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started to implement task: %s%n", name, task);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s finished to implement task: %s%n", name, task);
    }

}
