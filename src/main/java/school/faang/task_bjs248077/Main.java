package school.faang.task_bjs248077;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Archer());
        army.addUnit(new Warrior());
        army.addUnit(new Wizard());

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
