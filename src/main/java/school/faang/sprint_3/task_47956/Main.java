package school.faang.sprint_3.task_47956;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Archer(30));
        army.addUnit(new Swordsman(35));

        int totalPower = army.calculateTotalPower();
    }
}
