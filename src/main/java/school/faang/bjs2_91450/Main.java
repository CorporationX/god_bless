package school.faang.bjs2_91450;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad<Archer> archers = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>(List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        army.calculateTotalPower();
        System.out.printf("Суммарная мощность армии: %d", army.getTotalPower().get());
    }
}
