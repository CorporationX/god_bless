package school.faang.task47878;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Mage(25));
        army.addUnit(new Mage(50));
        army.addUnit(new Archer(40));
        army.addUnit(new Swordsman(30));

        int totalPower = army.calculateTotalPower();
        System.out.println(" Общая сила армии " + totalPower);
    }
}
