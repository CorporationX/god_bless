package faang.school.godbless.SkyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String target;

    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " " + target + " уничтожен");
        }
    }
}
