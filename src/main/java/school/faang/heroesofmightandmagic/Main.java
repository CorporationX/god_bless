package school.faang.heroesofmightandmagic;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final Army ARMY = new Army();
    private static final int ARCHER_POWER = 25;
    private static final int SWORDSMAN_POWER = 35;
    private static final int MAGE_POWER = 45;
    private static final int POWER_UP_BUFF = 5;

    public static void main(String[] args) {
        try {
            Squad archers = new Squad("Archers", List.of(new Archer(ARCHER_POWER),
                    new Archer(ARCHER_POWER + POWER_UP_BUFF)));
            Squad swordsmen = new Squad("Swordsmen", List.of(new Swordsman(SWORDSMAN_POWER),
                    new Swordsman(SWORDSMAN_POWER + POWER_UP_BUFF)));
            Squad mages = new Squad("Mages", List.of(new Mage(MAGE_POWER),
                    new Mage(MAGE_POWER + POWER_UP_BUFF)));

            ARMY.addSquad(archers);
            ARMY.addSquad(swordsmen);
            ARMY.addSquad(mages);

            log.info("Army total power: {}", ARMY.calculateTotalPower());
        } catch (InterruptedException exception) {
            log.error("Thread interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
