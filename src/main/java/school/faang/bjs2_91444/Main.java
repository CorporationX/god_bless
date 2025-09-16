package school.faang.bjs2_91444;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(35), new Swordsman(33),
                new Swordsman(39), new Swordsman(41),
                new Swordsman(35)));
        Squad archers = new Squad("Лучники", List.of(new Archer(44),
                new Archer(43), new Archer(39), new Archer(47), new Archer(45)));
        Squad mages = new Squad("Маги", List.of(new Mage(25),
                new Mage(23), new Mage(29), new Mage(31), new Mage(25)));

        System.out.println("Общая сила команды мечников: " + Squad.calculateSquadPower(swordsmen));
        System.out.println("Общая сила команды лучников: " + Squad.calculateSquadPower(archers));
        System.out.println("Общая сила команды магов: " + Squad.calculateSquadPower(mages));
    }
}
