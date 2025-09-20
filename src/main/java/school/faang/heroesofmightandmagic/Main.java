package school.faang.heroesofmightandmagic;

import school.faang.heroesofmightandmagic.fighters.Archer;
import school.faang.heroesofmightandmagic.fighters.Mage;
import school.faang.heroesofmightandmagic.fighters.Swordsman;
import school.faang.heroesofmightandmagic.units.Army;
import school.faang.heroesofmightandmagic.units.Squad;

import java.util.List;

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
        System.out.println("Общая сила армии: " + totalPower);
    }
}
