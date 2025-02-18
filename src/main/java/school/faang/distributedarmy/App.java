package school.faang.distributedarmy;

import java.util.List;

public class App {
    public static void main(String[] args) throws ArmyException {
        try {
            Army army = new Army();

            // Создаём отряды
            Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
            Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
            Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

            // Добавляем отряды в армию
            army.addSquad(archers);
            army.addSquad(swordsmen);
            army.addSquad(mages);

            // Вычисляем общую силу армии
            int totalPower = army.calculateTotalPower();
            System.out.println("Общая сила армии: " + totalPower);
        } catch (ArmyException e) {
            throw new ArmyException("Вычисление общей силы армии было прервано", e);
        }
    }
}
