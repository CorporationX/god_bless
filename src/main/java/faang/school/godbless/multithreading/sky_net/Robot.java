package faang.school.godbless.multithreading.sky_net;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Robot implements Runnable {
    private String model;
    private final Target target;

    public void attack() {
        synchronized (target) {
            System.out.println(model + " is attacking " + target.getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            System.out.println(model + " destroyed " + target.getName());
        }
        }

    @Override
    public void run() {
        attack();
    }
}
