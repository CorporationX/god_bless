package faang.school.godbless.Army;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(24));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Swordsman(44));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
