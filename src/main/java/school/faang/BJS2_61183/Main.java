package school.faang.BJS2_61183;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String TOTAL_POWER = "Total power of army {} - {}";

    public static void main(String[] args) throws InterruptedException {
        // Создаём отряды
        Squad archers = new Squad("Archers");
        archers.addAllToSquad(List.of(new Archer("Archer1", 25), new Archer("Archer2", 30)));
        archers.addToSquad(new Archer("Archer3", 35));
        Squad swordsmen = new Squad("Swordsmen");
        swordsmen.addAllToSquad(List.of(new Swordsman("Swordsman1", 40), new Swordsman("Swordsman2", 35)));
        Squad mages = new Squad("Mages");
        mages.addAllToSquad(List.of(new Mage("Mage1", 50), new Mage("Mage2", 45)));

        // Добавляем отряды в армию
        Army army = new Army("Army");
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу армии
        int totalPower = army.calculateTotalPower();
        logger.info(TOTAL_POWER, army.getName(), totalPower);
    }

}
