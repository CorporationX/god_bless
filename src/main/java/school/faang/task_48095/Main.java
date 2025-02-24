package school.faang.task_48095;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));   // Поток 1
        army.addUnit(new Swordsman(40)); // Поток 2
        army.addUnit(new Mage(50));     // Поток 3
        army.addUnit(new Mage(20));     // Поток 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
