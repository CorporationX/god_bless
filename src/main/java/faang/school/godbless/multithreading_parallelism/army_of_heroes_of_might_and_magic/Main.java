package faang.school.godbless.multithreading_parallelism.army_of_heroes_of_might_and_magic;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Archer(10));
        army.addUnit(new Archer(20));
        army.addUnit(new Archer(30));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(50));
        army.addUnit(new Swordsman(60));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(200));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
