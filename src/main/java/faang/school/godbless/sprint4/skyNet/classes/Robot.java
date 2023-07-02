package faang.school.godbless.sprint4.skyNet.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private Target target;

    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " attacking " + target.getName());
        }
    }
}
