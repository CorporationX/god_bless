package school.faang.bjs2_91500;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(List.of(new Mage(50), new Mage(45)));
        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);
        int totalPower = army.calculateTotalPower();
        log.info("Общая сила армии: {}", totalPower);
    }
}
