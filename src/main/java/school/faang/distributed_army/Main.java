package school.faang.distributed_army;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        // Создаём отряды
        Squad archers = new Squad(List.of(new Archer(20), new Archer(40)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad( List.of(new Mage(50), new Mage(45)));

        // Добавляем отряды в армию
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу армии
        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

}
