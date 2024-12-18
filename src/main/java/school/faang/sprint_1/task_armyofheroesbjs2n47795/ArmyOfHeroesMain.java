package school.faang.sprint_1.task_armyofheroesbjs2n47795;

public class ArmyOfHeroesMain {
    private static int UNIT_CAPACITY = 100;

    public static void main(String[] args) {
        Army army = new Army();
        for (int i = 0; i < UNIT_CAPACITY; i++) {
            army.addUnit(new Archer(25));
            army.addUnit(new Swordsman(40));
            army.addUnit(new Mage(50));
        }

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
