package sprint4.skynet;

import lombok.Data;

@Data
public class Robot implements Runnable {
    private static final int LOW_HEALTH_LIMIT = 0;
    private static final boolean DESTROYED = true;
    private final String name;
    private final int damage = 25;
    private int health = 125;
    private Robot target;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(Robot target, String name) {
        this.target = target;
        this.name = name;
    }

    @Override
    public void run() {
        while(!attack()) {
            System.out.printf("%s inflicted nonlethal damage\n", name);
        }
    }

    public boolean attack() {
        synchronized (target) {
            if (target.getHealth() == LOW_HEALTH_LIMIT) {
                return DESTROYED;
            }
            System.out.printf("%s attacks %s (health now = %d)\n", name, target.getName(), target.getHealth());
            dealDamage();
            System.out.printf("%s has %d hp left\n", target.getName(), target.getHealth());
        }
        return target.getHealth() == LOW_HEALTH_LIMIT;
    }

    private void dealDamage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        target.setHealth(target.getHealth() - damage);
        if (target.getHealth() <= LOW_HEALTH_LIMIT) {
            target.setHealth(LOW_HEALTH_LIMIT);
            System.out.printf("%s destroyed %s\n", name, target.getName());
        }
    }
}
