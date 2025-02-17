package school.faang.heroesofmightandmagic;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final Army ARMY = new Army();

    public static void main(String[] args) {
        try {
            Squad archers = new Squad("Archers", List.of(new Archer(25), new Archer(30)));
            Squad swordsmen =
                    new Squad("Swordsmen", List.of(new Swordsman(40), new Swordsman(35)));
            Squad mages = new Squad("Mages", List.of(new Mage(50), new Mage(45)));

            ARMY.addSquad(archers);
            ARMY.addSquad(swordsmen);
            ARMY.addSquad(mages);

            log.info("Army total power: {}", ARMY.calculateTotalPower());
        } catch (InterruptedException exception) {
            log.error("Thread interrupted. {}\n{}", exception, Thread.currentThread().getName());
        }

    }
}
