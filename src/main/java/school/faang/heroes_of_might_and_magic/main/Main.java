package school.faang.heroes_of_might_and_magic.main;

import school.faang.heroes_of_might_and_magic.groups.Army;
import school.faang.heroes_of_might_and_magic.groups.Squad;
import school.faang.heroes_of_might_and_magic.warriors.Archer;
import school.faang.heroes_of_might_and_magic.warriors.Mage;
import school.faang.heroes_of_might_and_magic.warriors.Swordsman;

import java.util.List;

public class Main {

    public static void main(String[] args) {
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
    }
}
