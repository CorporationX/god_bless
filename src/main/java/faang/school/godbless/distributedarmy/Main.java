package faang.school.godbless.distributedarmy;


public class Main {
    public static void distributedarmy() throws InterruptedException {
        Army army = new Army();
        army.add(new Archer(25)); // считаем в потоке 1
        army.add(new Swordsman(40)); // считаем в потоке 2
        army.add(new Mage(50)); // считаем в потоке 3
        army.add(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}