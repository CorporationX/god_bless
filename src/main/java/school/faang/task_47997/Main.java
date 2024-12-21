package school.faang.task_47997;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addWarrior(new Archer(25));
        army.addWarrior(new Swordsman(40));
        army.addWarrior(new Mage(50));
        army.addWarrior(new Mage(20));

        System.out.printf("Общая сила армии: << %d >>", army.calculateTotalPower());
    }
}
