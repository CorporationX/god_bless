package school.faang.armyofheroes;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        try {
            army.addSquad(archers);
            army.addSquad(swordsmen);
            army.addSquad(mages);

            int totalPower = army.calculateTotalPower();
            log.info("Общая сила армии: {}", totalPower);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}