package school.faang.task_43950;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Trump");
        Character archer = new Archer(null);

        startFight(warrior, archer);
    }

    protected static void startFight(Character attacker, Character defender) {
        Random random = new Random();

        while (!attacker.isDead() && !defender.isDead()) {
            int nextAttacker = random.nextInt(3);

            if (nextAttacker == 0) {
                attacker.attack(defender);
            } else if (nextAttacker == 1) {
                defender.attack(attacker);
            } else {
                applyBleedingEffect(attacker, defender);
            }
        }

        Character loser = attacker.isDead() ? attacker : defender;
        log.info("💀{} is dead!", loser.getName());
    }

    protected static void applyBleedingEffect(Character attacker, Character defender) {
        int attackerBleeding = getRandomBleedingAmount();
        int defenderBleeding = getRandomBleedingAmount();

        log.info("Bleeding effect!");

        attacker.takeDamage(attackerBleeding);
        defender.takeDamage(defenderBleeding);
    }

    private static int getRandomBleedingAmount() {
        return new Random().nextInt(5);
    }
}