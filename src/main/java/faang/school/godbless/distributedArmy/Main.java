package faang.school.godbless.distributedArmy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnitsToList(new Archer(25)); // считаем в потоке 1
        army.addUnitsToList(new Swordsman(40)); // считаем в потоке 2
        army.addUnitsToList(new Mage(50)); // считаем в потоке 3
        army.addUnitsToList(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
