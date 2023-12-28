package faang.school.godbless.parallelism.army;

public class TotalArmyPowerApp {

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(10));
        army.addUnit(new Swordsman(100));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(70));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

}
