package school.faang;

import school.faang.units.Archer;
import school.faang.units.Army;
import school.faang.units.Squad;
import school.faang.units.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Army army = new Army(List.of(archers, swordsmen));

        try {
            System.out.println("Общая сила армии: " + army.calculateTotalPower());
        } catch (InterruptedException e) {
            throw new IllegalStateException("An interruption occurred while calculating the total army strength, ", e);
        }
    }
}
