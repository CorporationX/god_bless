package faang.school.godbless.distributed_army_of_heroes_of_might_and_magic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Archer archer = new Archer(2);
        System.out.println(archer.getPower());

        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
