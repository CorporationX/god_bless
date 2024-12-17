package school.faang.sprint3.task_47805;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addUnit(new Archer(40));
        army.addUnit(new Mage(20));
        army.addUnit(new Swordsman(50));
        army.addUnit(new Mage(40));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
