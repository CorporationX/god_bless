package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String name;
    private String target;

    public void attack() {
        synchronized (target) {
            System.out.println("Robot " + name + " found a target " + target);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Robot " + name + " destroyed the " + target);
        }
    }
}
