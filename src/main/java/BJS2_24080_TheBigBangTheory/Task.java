package BJS2_24080_TheBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.println("Starting " + getTask() + " by: " + getName());
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(getTask() + " has been aborted!");
            throw new RuntimeException(e);
        }
        long finish = System.currentTimeMillis();
        System.out.println(getTask() + " is done by " + getName() + "!");
        System.out.println("This task have taken " + ((finish - start) / 1000) + " seconds");
    }
}
