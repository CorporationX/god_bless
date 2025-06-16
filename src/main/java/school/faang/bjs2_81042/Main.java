package school.faang.bjs2_81042;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_81042.divisions.Army;
import school.faang.bjs2_81042.divisions.Squad;
import school.faang.bjs2_81042.units.Archer;
import school.faang.bjs2_81042.units.Mage;
import school.faang.bjs2_81042.units.Swordsman;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        log.info("Общая сила армии: {}", totalPower);
    }
}
