package school.faang.multithreading.parallelism.bjs2_91330;

import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        // Создаём отряды
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30), new Swordsman(44)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        // Добавляем отряды в армию
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу армии
        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}