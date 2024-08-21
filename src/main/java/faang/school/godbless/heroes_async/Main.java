package faang.school.godbless.heroes_async;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new ArcherUnit(25)); // считаем в потоке 1
        army.addUnit(new SwordmanUnit(40)); // считаем в потоке 2
        army.addUnit(new MageUnit(50)); // считаем в потоке 3
        army.addUnit(new MageUnit(20)); // считаем в потоке 4

        int totalPower = 0;
        try {
            totalPower = army.calculateTotalPower();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Total army power: " + totalPower);
    }
}
