package school.faang.sprint3.task2;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(35));
        army.addUnit(new Mage(45));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
