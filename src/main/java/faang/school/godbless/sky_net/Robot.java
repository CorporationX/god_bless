package faang.school.godbless.sky_net;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private String name;
    private final Target target;

    public void attack() {
        synchronized (target) {
            System.out.println("Robot " + getName() + " attacking: " + target.getName());
        }
    }
}
