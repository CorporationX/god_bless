package faang.school.godbless.skynet;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Robot {

    @Setter
    private static List<Target> battlefield;
    private String name;
    private int targetKilled = 0;

    public Robot(String name) {
        this.name = name;
    }

    public void attack() {
        for (Target target : battlefield) {
            synchronized (target) {
                if (target.getHealth() == 0) {
                    continue;
                }

                System.out.println(name + " attacking target: " + target.getName());
                target.setHealth(0);
                System.out.println(name + " killed target: " + target.getName());
                targetKilled++;
            }
        }

        System.out.println(name + " has killed " + targetKilled);
    }
}

