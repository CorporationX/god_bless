package Sprint_4_SkyNet;

import lombok.Data;

@Data
public class Robot {
    private final String target;

    public Robot(String target) {
        this.target = target;
    }

    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " атаковал цель " + target);

        }

    }
}
