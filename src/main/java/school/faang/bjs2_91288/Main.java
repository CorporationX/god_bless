package school.faang.bjs2_91288;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad<Archer> archers = new Squad<>("Archers", List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>("Swordsman",
                List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>("Mage", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army strength: " + totalPower);
    }
}
