package school.faang.BJS2_72305;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Squad archerSquad = new Squad("Archer Squad", List.of(
                new Archer(10),
                new Archer(20),
                new Archer(30)
        ));

        Squad mageSquad = new Squad("Mage Squad", List.of(
                new Mage(15),
                new Mage(25),
                new Mage(35)
        ));

        Squad swordsmanSquad = new Squad("Sword Squad", List.of(
                new Swordsman(5),
                new Swordsman(10),
                new Swordsman(15)
        ));

        Army army = new Army();
        army.addSquad(archerSquad);
        army.addSquad(mageSquad);
        army.addSquad(swordsmanSquad);

        System.out.println("Total Army Power: " + army.calculateTotalPower());
    }
}
