package school.faang.bjs291341;

import school.faang.bjs291341.warrior.Archer;
import school.faang.bjs291341.warrior.Mage;
import school.faang.bjs291341.warrior.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём отряды
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        // Добавляем отряды в армию
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        try {
            // Вычисляем общую силу армии
            int totalPower = army.calculateTotalPower();
            System.out.println("Общая сила армии: " + totalPower);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
