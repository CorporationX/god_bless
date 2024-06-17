package faang.school.godbless.module1.sprint3.task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(100));
        army.addUnit(new Mage(70));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Warrior(150));
        System.out.println(army.calculateTotalPower());

    }
}
