package faang.school.godbless.heroes_2;

public class ArmyRunner {

    public static void main(String[] args) {
        Army army = new Army();
        army.addCreature(new Archer(25)); // считаем в потоке 1
        army.addCreature(new Swordsman(40)); // считаем в потоке 2
        army.addCreature(new Mage(50)); // считаем в потоке 3
        army.addCreature(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
