package school.faang;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army;
        army = new Army();

        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        Squad mages = new Squad();
        mages.addUnit(new Mage(35));
        mages.addUnit(new Mage(20));

        List<Squad> squadsToAdd = Arrays.asList(archers, swordsmen, mages);
        army.addSquads(squadsToAdd);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
