package faang.school.godbless.multithreadingS4.skyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String name;
    private int damage;
    private Target target;

    public void attack() {
        System.out.printf("%s prepare to attack.%n", name);
        try {
            Thread.sleep(damage * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (target) {
            System.out.println("\t" + name + " attacks the target.");
            int healthPointAfterDamage = target.getHealthPoints() - damage;
            target.setHealthPoints(healthPointAfterDamage);
        }

    }
}
