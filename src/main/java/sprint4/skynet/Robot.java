package sprint4.skynet;

import lombok.Data;

@Data
public class Robot {
    private Robot target;
    private final String name;
    private int health = 125;
    private int damage = 25;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(Robot target, String name) {
        this.target = target;
        this.name = name;
    }

    public boolean attack() {
        synchronized (target) {
            System.out.printf("%s attacks %s (hp = %d)\n", name, target.getName(), target.getHealth());
            dealDamage();
            System.out.printf("%s has %d hp left", target.getName(), target.getHealth());
        }
        return target.getHealth() == 0;
    }

    private void dealDamage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        target.setHealth(target.getHealth() - damage);
        if (target.getHealth() < 0) {
            target.setHealth(0);
        }
    }
}
