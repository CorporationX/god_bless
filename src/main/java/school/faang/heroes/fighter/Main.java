package school.faang.heroes.fighter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad<Mage> magesSquad = new Squad<>(List.of(new Mage(), new Mage(), new Mage(), new Mage()));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(), new Swordsman(), new Swordsman()));
        Squad<Archer> archers = new Squad<>(List.of(new Archer(), new Archer()));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(magesSquad);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
