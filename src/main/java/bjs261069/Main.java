package bjs261069;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fighter> archers = new ArrayList<>();
        archers.add(new Archer(25));
        archers.add(new Archer(30));

        List<Fighter> swordsmen = new ArrayList<>();
        swordsmen.add(new Swordsman(40));
        swordsmen.add(new Swordsman(35));

        List<Fighter> mages = new ArrayList<>();
        mages.add(new Mage(50));
        mages.add(new Mage(45));

        Squad squadArchers = new Squad("Archers", archers);
        Squad squadSwordsmen = new Squad("Swordsmen", swordsmen);
        Squad squadMages = new Squad("Mages", mages);

        Army army = new Army();
        List<Squad> squads = army.getSquads();
        squads.add(squadArchers);
        squads.add(squadSwordsmen);
        squads.add(squadMages);

        int totalPower = army.calculateTotalPower(squads);
        System.out.println("Total army`s power: " + totalPower);
    }
}
