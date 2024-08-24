package faang.school.godbless.bjs225893;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String description;

    public void run() {
        System.out.println(this.name + " is doing his task: " + this.description);
        try {
            Thread.sleep((new Random().nextInt(5) + 1) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " finished his task");
    }
}