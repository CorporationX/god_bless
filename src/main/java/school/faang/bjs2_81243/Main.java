package school.faang.bjs2_81243;

import java.util.List;

public class Main {
    private static final Squad<Archer> ARCHERS
            = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
    private static final Squad<Swordsman> SWORDSMEN
            = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
    private static final Squad<Mage> MAGES
            = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        // Добавляем отряды в армию
        army.addSquad(ARCHERS);
        army.addSquad(SWORDSMEN);
        army.addSquad(MAGES);

        // Вычисляем общую силу армии
        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
