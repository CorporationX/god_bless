package school.faang.bjs2_81166;

import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Squad<Archer> archers = new Squad<>(List.of(new Archer(35), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>(List.of(new Mage(50), new Mage(45)));
        Squad<KnightRider> knightRider = new Squad<>(List.of(new KnightRider(80), new KnightRider(90)));

        Army army = new Army();
        army.addSquad(swordsmen);
        army.addSquad(mages);
        army.addSquad(archers);
        army.addSquad(knightRider);

        int totalPower = army.calculateTotalPower();
        System.out.println("The overall strength of the army : " + totalPower);
    }
}
