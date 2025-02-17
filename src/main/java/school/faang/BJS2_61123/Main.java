package school.faang.BJS2_61123;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Army army = new Army();

        Squad archers = new Squad("Archers", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Swordsmen", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Mages", List.of(new Mage(50), new Mage(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total strength: " + totalPower);
    }
}
