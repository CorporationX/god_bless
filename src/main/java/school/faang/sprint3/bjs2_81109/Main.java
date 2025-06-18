package school.faang.sprint3.bjs2_81109;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём отряды
        Squad<Archer> archers = new Squad<>("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        // Добавляем отряды в армию
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу армии
        double totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
