package faang.school.godbless.synchronizationWaitNotify.skyNet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Robot {
    private String name;
    private final Target target;

    public void attack() {
        synchronized(target) {
            System.out.printf("Робот %s атакует цель %s\n", name, target.getName());
            try {
                Thread.sleep(new Random().nextInt(2000) + 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Робот %s уничтожил цель %s\n", name, target.getName());
        }
    }
}
