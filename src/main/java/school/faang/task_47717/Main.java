package school.faang.task_47717;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Mage(50));
        army.addUnit(new Swordsman(15));
        army.addUnit(new Archer(30));
        army.addUnit(new Mage(10));
        army.addUnit(new Swordsman(55));
        army.addUnit(new Archer(25));
        army.addUnit(new Mage(5));
        army.addUnit(new Swordsman(1));
        army.addUnit(new Archer(5));
        army.addUnit(new Mage(510));
        army.addUnit(new Swordsman(125));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии " + totalPower);
    }
}
