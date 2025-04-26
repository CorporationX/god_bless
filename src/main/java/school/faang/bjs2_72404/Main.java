package school.faang.bjs2_72404;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad<Archer> archers = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>(List.of(new Mage(50), new Mage(45)));

        Army army = new Army(List.of(archers, swordsmen, mages));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
