package school.faang.heroe;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        Squad archer = new Squad("Лучники", List.of(new Archer(25), new Archer(35)));
        Squad mage = new Squad("Маги", List.of(new Mage(50), new Mage(45)));
        Squad swordsman = new Squad("Мечники", List.of(new Swordsman(30), new Swordsman(45)));

        army.addSquad(archer);
        army.addSquad(mage);
        army.addSquad(swordsman);

        int totalPower = army.calculateTotalPower();
        System.out.printf("Total power Army%d ", totalPower);
    }
}
