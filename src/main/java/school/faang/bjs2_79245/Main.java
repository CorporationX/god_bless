package school.faang.bjs2_79245;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character kaladin = new Warrior("Kaladin");
        Character legolas = new Archer("Legolas", 3, 8, 5);

        try {
            kaladin.attack(legolas);
            log.info("{}: {}", kaladin.getName(), kaladin.getHealthPoints());
            log.info("{}: {}", legolas.getName(), legolas.getHealthPoints());

            legolas.attack(kaladin);
            log.info(kaladin.getName() + ": " + kaladin.getHealthPoints());
            log.info(legolas.getName() + ": " + legolas.getHealthPoints());
        } catch (IllegalStateException e) {
            log.info("I have bad news for you, buddy...");
        }
    }
}
