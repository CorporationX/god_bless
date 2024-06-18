package faang.school.godbless.big_bang_teory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " is trying to solve " + task + " problem");
        try {
            Thread.sleep(new Random().nextInt(1, 11) * 1000L);
            System.out.println(name + " solved " + task + " problem");
        } catch (InterruptedException e) {
            System.out.println(name + " could not solve " + task + "problem");
        }
    }
}
