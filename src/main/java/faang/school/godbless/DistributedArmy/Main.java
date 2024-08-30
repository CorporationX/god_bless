package faang.school.godbless.DistributedArmy;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        System.out.println("total army power is: " + army.calculateTotalPower());
    }
}
