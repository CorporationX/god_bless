package school.faang.distributedarmy;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        Squad archers = new Squad();
        archers.addHero(new Archer(25));
        archers.addHero(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addHero(new Swordsman(40));
        swordsmen.addHero(new Swordsman(35));

        Squad mages = new Squad();
        mages.addHero(new Mage(40));
        mages.addHero(new Mage(35));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}