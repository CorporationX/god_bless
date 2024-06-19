package faang.school.godbless.multithreading.heroes;

public class Main {

    public static void main(String[] args) {
        Army army = new Army();
        army.addSoldier(new Archer(25)); // считаем в потоке 1
        army.addSoldier(new Swordsman(40)); // считаем в потоке 2
        army.addSoldier(new Mage(50)); // считаем в потоке 3
        army.addSoldier(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
