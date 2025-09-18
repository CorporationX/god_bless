package school.faang.bjs2_90000;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad arhcers = new Squad("Archers", List.of(new Archer(25), new Archer(25)));
        Squad swordsmans = new Squad("Swordsman", List.of(new Swordsman(50), new Swordsman(50)));
        Squad mages = new Squad("Mages", List.of(new Mage(75), new Mage(75)));

        Army army = new Army();
        army.addSquad(arhcers);
        army.addSquad(swordsmans);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power of the army = " + totalPower);
    }
}
