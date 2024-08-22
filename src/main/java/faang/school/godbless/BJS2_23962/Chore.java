package faang.school.godbless.BJS2_23962;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.printf("%s has started %s%n", Thread.currentThread().getName(), this.chore);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task is done by " + Thread.currentThread().getName());
    }
}
