package faang.school.godbless.swordandmagic;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Character> characters = List.of(new Archer(25), new Swordsman(40), new Mage(50), new Mage(20));
        Army army = new Army(characters);

        try {
            int totalPower = army.calculateTotalPower();
            System.out.println("Total army power: " + totalPower);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
