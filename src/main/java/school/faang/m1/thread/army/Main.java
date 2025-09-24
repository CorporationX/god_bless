package school.faang.m1.thread.army;

import school.faang.m1.thread.army.units.Archer;
import school.faang.m1.thread.army.units.Mage;
import school.faang.m1.thread.army.units.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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