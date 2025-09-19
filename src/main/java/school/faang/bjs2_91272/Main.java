package school.faang.bjs2_91272;

import school.faang.bjs2_91272.character.Archer;
import school.faang.bjs2_91272.character.Mage;
import school.faang.bjs2_91272.character.Swordsman;
import school.faang.bjs2_91272.character_groups.Army;
import school.faang.bjs2_91272.character_groups.Squad;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad<Archer> archers = new Squad<>(List.of(new Archer(), new Archer(), new Archer()));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(), new Swordsman(), new Swordsman()));
        Squad<Mage> mages = new Squad<>(List.of(new Mage(), new Mage(), new Mage()));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
