package faang.school.godbless.skyNet;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Robot {
    private String name;
    private final String target;
    private int energy;

    public Robot(String name, String target, int energy) {
        this.name = name;
        this.target = target;
        this.energy = energy;
    }

    public void attack() {
        synchronized (target) {
            if (energy <= 0) {
                System.out.println(name + " has no energy left to attack");
                return;
            }

            System.out.println(name + " attacking target: " + target + ", energy: " + energy);
            energy--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " completed attack on target: " + target);
        }
    }
}
