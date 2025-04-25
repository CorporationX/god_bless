package school.faang.bjs2_72251;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_72251.model.unit.Archer;
import school.faang.bjs2_72251.model.Army;
import school.faang.bjs2_72251.model.unit.Mage;
import school.faang.bjs2_72251.model.Squad;
import school.faang.bjs2_72251.model.unit.Swordsman;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        log.info("Общая сила армии: {}", army.calculateTotalPower());
        army.dispose();
    }
}