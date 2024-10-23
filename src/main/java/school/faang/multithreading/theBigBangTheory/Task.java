package school.faang.multithreading.theBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " started to complete the task " + task);
            Thread.sleep(new Random().nextInt(30000)+1000);
            System.out.println(name + " completed the task " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted task " + task);
            e.printStackTrace();
        }
    }
}
