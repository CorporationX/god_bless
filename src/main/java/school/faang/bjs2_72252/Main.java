package school.faang.bjs2_72252;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Squad squadOfArchers = new Squad();
        squadOfArchers.addUnit(new Archer(), 10);
        Squad squadOfWarriors = new Squad();
        squadOfWarriors.addUnit(new Swordsman(), 15);
        Squad squadOfMages = new Squad();
        squadOfMages.addUnit(new Mage(), 50);

        List<Squad> squads = List.of(squadOfArchers, squadOfWarriors, squadOfMages);

        Army army = new Army(squads);

        System.out.println(army.calculateArmyPower());
    }
}
