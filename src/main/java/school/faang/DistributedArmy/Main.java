package school.faang.DistributedArmy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
