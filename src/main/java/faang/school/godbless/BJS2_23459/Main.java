package faang.school.godbless.BJS2_23459;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Division> divisions = new ArrayList<>();
        divisions.add(new Archer(12));
        divisions.add(new Archer(2));
        divisions.add(new Mage(20));
        divisions.add(new Mage(25));
        divisions.add(new Swordsman(14));
        divisions.add(new Swordsman(30));
        Army army = new Army(divisions);
        System.out.println("Total army power is " + army.calculateTotalPower());
    }
}
