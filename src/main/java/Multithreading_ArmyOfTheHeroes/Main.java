package Multithreading_ArmyOfTheHeroes;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = List.of(
                new Archer(40), new Swordsman(50), new Mage(35),
                new Archer(45), new Swordsman(26), new Mage(40),
                new Archer(25), new Swordsman(35), new Mage(69),
                new Archer(55), new Swordsman(42), new Mage(44)
        );

        Army army = new Army(characters);
        System.out.println("Total army power - " + army.calculateTotalPower());
    }
}
