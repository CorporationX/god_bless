package school.faang.task_47681;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Unit(25, "Archer"));
        army.addUnit(new Unit(40, "Swordsman"));
        army.addUnit(new Unit(50, "Mage"));
        army.addUnit(new Unit(20, "Mage"));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);

        army.getUnits().forEach(unit ->
                System.out.println(unit.getType() + " с силой " + unit.getPower()));
    }
}