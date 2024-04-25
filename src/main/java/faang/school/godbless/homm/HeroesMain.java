package faang.school.godbless.homm;

public class HeroesMain {

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Archer(35));
        army.addUnit(new Swordsman(50));
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower;
        try {
            totalPower = army.calculateTotalPower();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total army power: " + totalPower);
    }
}
