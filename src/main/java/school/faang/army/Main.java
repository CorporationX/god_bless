package school.faang.army;

import lombok.extern.slf4j.Slf4j;
import school.faang.army.army.Army;
import school.faang.army.army.Squad;
import school.faang.army.model.Archer;
import school.faang.army.model.Mage;
import school.faang.army.model.Swordsman;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(new ArrayList<>());

        Squad archers = new Squad(List.of(new Archer(20), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(List.of(new Mage(55), new Mage(50)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalArmyPower = army.calculateTotalPower();
        log.info("Total army power: {}", totalArmyPower);
    }
}