package faang.school.godbless.Army_Of_Heroes;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = List.of(new Archer(45), new Swordsman(35), new Mage(50), new Mage(50));
        Army army = new Army(characters);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power " + totalPower);
    }
}
