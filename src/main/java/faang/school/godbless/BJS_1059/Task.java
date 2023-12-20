package faang.school.godbless.BJS_1059;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;



    @Override
    public void run() {
        System.out.println(task+" is going to start");
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException("The task was interrupted");
        }
        System.out.println(task+" is completed by "+name);
    }
}
