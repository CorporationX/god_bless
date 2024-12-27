package school.faang.task_48171;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Archer(29));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power: " + totalPower);
    }
}
