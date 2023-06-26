package faang.school.godbless.sprint_3.multithreading.distributed_army;

public class Main {
    public static void main(String[] args) {
        Army firstArmy = new Army();
        firstArmy.addUnit(new Archer(20));
        firstArmy.addUnit(new Swordsman(40));
        firstArmy.addUnit(new Mage(15));
        int result = firstArmy.calculateTotalPower();
        System.out.println(result);
        Army secondArmy = new Army();
        secondArmy.addUnit(new Archer(25));
        secondArmy.addUnit(new Swordsman(35));
        secondArmy.addUnit(new Mage(15));
        secondArmy.addUnit(new Archer(25));
        int secondResult = secondArmy.calculateTotalPower();
        System.out.println(secondResult);

    }
}
