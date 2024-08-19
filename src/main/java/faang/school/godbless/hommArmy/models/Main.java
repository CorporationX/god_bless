package faang.school.godbless.hommArmy.models;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        Archer archer = new Archer(100);
        Mage mage = new Mage(100);
        Swordsman swordsman = new Swordsman(100);

        army.addUnit(archer);
        army.addUnit(mage);
        army.addUnit(swordsman);
        army.addUnit(archer);
        army.addUnit(mage);
        army.addUnit(swordsman);
        army.addUnit(archer);
        army.addUnit(mage);
        army.addUnit(swordsman);
        army.addUnit(archer);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
