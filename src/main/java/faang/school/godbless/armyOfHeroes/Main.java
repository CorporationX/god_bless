package faang.school.godbless.armyOfHeroes;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(10));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}