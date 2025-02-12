package bjs256450;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        generateTestData();
    }

    private static void generateTestData() {
        Character warrior = new Warrior("Warrior");
        Character firstArcher = new Archer("FirstArcher");
        for (int i = 0; i < 10; i++) {
            warrior.attack(firstArcher);
            if (firstArcher.getHealth() > 0) {
                logger.info("Strike {} FirstArcher`s health: {}", i, firstArcher.getHealth());
            }
        }

        Character secondArcher = new Archer("SecondArcher");
        for (int i = 0; i < 10; i++) {
            secondArcher.attack(warrior);
            if (warrior.getHealth() > 0) {
                logger.info("Strike {} Warrior`s health: {}", i, warrior.getHealth());
            }
        }
    }
}