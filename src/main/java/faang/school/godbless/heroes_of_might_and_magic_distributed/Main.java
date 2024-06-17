package faang.school.godbless.heroes_of_might_and_magic_distributed;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
