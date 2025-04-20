package school.faang.parallelism.homm_army_distributor;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        Squad archers = new Squad("Archers", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Swordsmen", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Mages", List.of(new Mage(50), new Mage(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        log.info("Total army power: {}", totalPower);
    }
}
