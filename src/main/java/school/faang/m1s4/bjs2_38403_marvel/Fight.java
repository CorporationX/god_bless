package school.faang.m1s4.bjs2_38403_marvel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fight {
    private static final long PAUSE_TIME = 250;

    public Superhero fight(Superhero attacker, Superhero defender) {
        int roundCounter = 1;
        restoreHp(attacker, defender);
        log.info("{} vs {}", attacker.getName(), defender.getName());
        while (attacker.getHp() > 0 || defender.getHp() > 0) {
            log.info("Round {} starts", roundCounter++);

            sleep();

            attacker.attack(defender);

            sleep();

            if (defender.isAlive()) {
                defender.attack(attacker);
            } else {
                sleep();
                log.info("{} loses", defender.getName());
                log.info("{} wins!!!", attacker.getName());
                return attacker;
            }

            sleep();

            if (!attacker.isAlive()) {
                log.info("{} loses", attacker.getName());
                log.info("{} wins!!!", defender.getName());
                return defender;
            }
        }
        return null;
    }

    private void restoreHp(Superhero attacker, Superhero defender) {
        attacker.setHp(attacker.getStrength() * 10);
        defender.setHp(defender.getStrength() * 10);
    }

    private void sleep() {
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }
}
