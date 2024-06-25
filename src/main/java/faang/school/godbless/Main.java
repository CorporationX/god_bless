package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Almas!");

        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(65));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(50));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}