package Multithreading.bc2612;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot implements Runnable {
    private String name;
    private String target;

    public void attack() {
        try {
            System.out.println(getName() + " attack target: " + getTarget());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Target" + getTarget() + "kill");
    }

    @Override
    public void run() {
        attack();
    }
}
