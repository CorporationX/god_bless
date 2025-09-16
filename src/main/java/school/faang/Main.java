package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Swordsman petro = new Swordsman(92);
        Squad swordsmen1 = new Squad("Мечники 1", List.of(new Swordsman(35), new Swordsman(33),
                new Swordsman(39), new Swordsman(-41), petro, new Swordsman(35)));
        System.out.println("Общая сила команды: " + Squad.calculateSquadPower(swordsmen1.getUnits()));
    }
}
