package faang.school.godbless.BJS2_11033;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(50));
        army.addUnit(new Archer(30));
        army.addUnit(new Mage(70));
        army.addUnit(new Mage(20));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(60));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
