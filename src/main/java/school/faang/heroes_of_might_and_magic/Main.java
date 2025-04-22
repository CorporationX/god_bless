package school.faang.heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad squad1 = new Squad(List.of(new Archer(), new Archer(), new Archer(), new Archer()));
        Squad squad2 = new Squad(List.of(new Mage(), new Mage(), new Mage()));
        Squad squad3 = new Squad(List.of(new Swordsman(), new Swordsman()));
        Army army = new Army(new ArrayList<>(List.of(squad1, squad2, squad3)));

        System.out.println(army.calculateTotalPower());

        Squad squad4 = new Squad(List.of(new Mage(), new Mage()));
        army.addSquad(squad4);

        System.out.println(army.calculateTotalPower());
    }
}
