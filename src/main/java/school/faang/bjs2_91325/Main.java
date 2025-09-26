package school.faang.bjs2_91325;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad("Лучники", List.of(new Archer(), new Archer()));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(), new Swordsman()));
        Squad mages = new Squad("Маги", List.of(new Mage(), new Mage()));

        Army army = new Army();

        army.getFullArmy().add(archers);
        army.getFullArmy().add(swordsmen);
        army.getFullArmy().add(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
