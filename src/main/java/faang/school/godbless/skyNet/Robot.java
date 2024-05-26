package faang.school.godbless.skyNet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot extends Thread {
    private final String target;

    public void attack() {
        synchronized (target) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(target + " is under attack");
        }
    }
}
