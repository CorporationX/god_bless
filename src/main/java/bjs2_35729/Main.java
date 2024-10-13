package bjs2_35729;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = List.of(
                new Archer(25),
                new Archer(50),
                new Swordsman(30),
                new Mage(60),
                new Swordsman(10),
                new Archer(30),
                new Mage(35),
                new Mage(20),
                new Swordsman(70),
                new Swordsman(15),
                new Archer(20)
        );

        Army army = new Army(characters);
        army.calculateTotalPower();
        System.out.println(army.getTotalPower());
    }
}
