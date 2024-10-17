package ru.kraiush.BJS2_36696;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started doing the task: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("The task: " + task + " of " + name + " was interrupted!");
        }
        System.out.println("The task: " + task + " was competed by: " + name + "!");
    }
}
