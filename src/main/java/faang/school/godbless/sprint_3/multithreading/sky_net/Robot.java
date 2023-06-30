package faang.school.godbless.sprint_3.multithreading.sky_net;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private String target;

    public synchronized void attack() {
        System.out.printf("Target: %s are dead!", target);
    }
}
