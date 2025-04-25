package school.faang.bjs2_72252;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad squadOfArchers = new Squad();
        for (int i = 0; i < 10; i++) {
            squadOfArchers.getUnits().add(new Archer());
        }
        Squad squadOfWarriors = new Squad();
        for (int i = 0; i < 10; i++) {
            squadOfArchers.getUnits().add(new Swordsman());
        }
        Squad squadOfMages = new Squad();
        for (int i = 0; i < 10; i++) {
            squadOfArchers.getUnits().add(new Mage());
        }

        List<Squad> squads = List.of(squadOfArchers, squadOfWarriors, squadOfMages);

        Army army = new Army(squads);

        System.out.println(army.calculateArmyPower(army.getSquads()));
    }
}
