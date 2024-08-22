package faang.school.godbless.bjs2_23452;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Swordsman(1));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
