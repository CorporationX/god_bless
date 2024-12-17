package school.faang.task_48006;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Unit(25, "Archer"));
        army.addUnit(new Unit(40, "Swordsman"));
        army.addUnit(new Unit(50, "Mage"));
        army.addUnit(new Unit(20, "Mage"));

        int totalPower = Army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}