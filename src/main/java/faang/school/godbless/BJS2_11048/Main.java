package faang.school.godbless.BJS2_11048;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        System.out.println("Total power: " + army.calculateTotalPower());
    }
}
