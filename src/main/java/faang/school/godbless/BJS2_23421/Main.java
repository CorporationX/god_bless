package faang.school.godbless.BJS2_23421;

public class Main {
    public static void main(String[] args) {
        var army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(44));
        army.addUnit(new Swordsman(23));
        army.addUnit(new Archer(15));
        army.addUnit(new Mage(44));
        army.addUnit(new Swordsman(23));
        army.addUnit(new Archer(15));
        army.addUnit(new Mage(44));
        army.addUnit(new Swordsman(23));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army's power: " + totalPower);
    }
}