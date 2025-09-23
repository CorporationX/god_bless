package school.faang.m1.thread.chore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Chore implements Runnable {

    @Getter
    private String chore;

    @Override
    public void run() {
        System.out.println("Doing " + chore + ". Thread: " + Thread.currentThread().getName());
    }
}
