package school.faang.module1.bjs2_81100;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Squad<Archer> archers = new Squad<>("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>("Маги", List.of(new Mage(50), new Mage(45)));

        List<Squad<? extends Warrior>> squads = List.of(archers, swordsmen, mages);
        Army army = new Army(squads);

        log.info("Общая сила армии: {}", army.calculateTotalPower());
    }
}