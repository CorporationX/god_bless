package school.faang.bjs2_61124;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        List<Squad> squads = List.of(
                new Squad("Archers", List.of(new Archer(25), new Archer(30))),
                new Squad("Swordsmen", List.of(new Swordsman(40), new Swordsman(35))),
                new Squad("Mages", List.of(new Mage(50), new Mage(45)))
        );

        squads.forEach(army::addSquad);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army strength: " + totalPower);
    }
}
