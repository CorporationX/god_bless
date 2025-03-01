package HeroesOfMightAndMagic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        Squad archers = new Squad(List.of(new Archer(25), new Archer(30), new Archer(40)));
        Squad swordsmen = new Squad(List.of(new Swordsman(30), new Swordsman(35), new Swordsman(50)));
        Squad mages = new Squad(List.of(new Mage(15), new Mage(30), new Mage(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("The overall strength of the army: " + army.calculateTotalPower());
    }
}
