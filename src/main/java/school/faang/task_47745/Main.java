package school.faang.task_47745;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        for (int i = 0; i < 3; i++) {
            army.addUnit(new Archer());
            army.addUnit(new Mage());
            army.addUnit(new Swordsman());
        }

        long totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);

    }

}
