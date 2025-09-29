package school.faang.bjs2_91490;

import school.faang.bjs2_91490.army.Army;
import school.faang.bjs2_91490.army.Squad;
import school.faang.bjs2_91490.fighters.Archer;
import school.faang.bjs2_91490.fighters.Mage;
import school.faang.bjs2_91490.fighters.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad<Archer> archers = new Squad<>("Лучники",
                List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>("Мечники",
                List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>("Маги",
                List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}