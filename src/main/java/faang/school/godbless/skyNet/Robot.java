package faang.school.godbless.skyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private Target target;

    public void attack() {
        synchronized (target) {
            System.out.println("Robot attacked " + target.getName());
        }
    }
}
