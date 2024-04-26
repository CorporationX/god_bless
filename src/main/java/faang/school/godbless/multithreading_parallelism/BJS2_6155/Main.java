package faang.school.godbless.multithreading_parallelism.BJS2_6155;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // cчитаем в потоке 1
        army.addUnit(new Swordsman(40)); // cчитаем в потоке 2
        army.addUnit(new Mage(50)); // cчитаем в потоке 3
        army.addUnit(new Mage(20)); // cчитаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
