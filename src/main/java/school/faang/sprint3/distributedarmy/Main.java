package school.faang.sprint3.distributedarmy;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Unit> units = List.of(new Archer(25), new Swordsman(34), new Mag(56),new Mag(56),
                new Archer(25), new Swordsman(34), new Mag(56),new Mag(56),
                new Archer(25), new Swordsman(34), new Mag(56),new Mag(56));

        Army army = new Army(units);
        int totalPower = army.calculateTotalPower();
        System.out.println("Total powers " + totalPower);
    }
}
