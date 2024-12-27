package school.faang.sprint_3.task_48341;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(20));
        army.addUnit(new Swordsman(50));
        army.addUnit(new Mage(60));
        army.addUnit(new Mage(10));

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}
