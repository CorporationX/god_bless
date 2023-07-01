package faang.school.godbless.skyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private int id;
    private final String target;

    public void attack() {
        synchronized (target) {
            System.out.println("Robot #" + id + " attacked a " + target);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Target has been eliminated by Robot # " + id);
        }
    }
}
