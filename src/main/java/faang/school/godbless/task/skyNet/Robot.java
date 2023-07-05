package faang.school.godbless.task.skyNet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private final String name;
    private final Target target;

    public void attack() {
        synchronized (target) {
            if (target.isAlive()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                target.setAlive(false);
                System.out.println(target.getName() + " was killed by " + this.getName());
            }
        }
    }
}
