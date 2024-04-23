package faang.school.godbless.army_of_heroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(93));
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(95));
        army.addUnit(new Archer(60));
        army.addUnit(new Swordsman(90));
        army.addUnit(new Mage(120));
        army.addUnit(new Mage(50));
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(70));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
