package school.faang.distributedarmy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));   // считаем в потоке 1
        army.addUnit(new Swordman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50));     // считаем в потоке 3
        army.addUnit(new Mage(20));     // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
