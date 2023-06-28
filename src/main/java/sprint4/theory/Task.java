package sprint4.theory;

import java.util.Random;

public record Task(String name, String task) implements Runnable {
    private static final int COMPLETION_RATE = 100;
    private static final int MAXIMUM_EXECUTION_SPEED = 10;
    private static final String PROGRESS = "The work on the %s is done on: %d%%\n";
    private static final Random RANDOM = new Random();
    @Override
    public void run() {
        System.out.printf("%s begins task %s\n", name, task);
        for (int i = 0; i < COMPLETION_RATE; i += RANDOM.nextInt(MAXIMUM_EXECUTION_SPEED)) {
            System.out.printf(PROGRESS, task, i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted\n");
            }
        }
        System.out.printf(PROGRESS, task, COMPLETION_RATE);
    }
}
