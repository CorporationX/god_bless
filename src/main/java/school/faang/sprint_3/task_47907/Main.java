package school.faang.sprint_3.task_47907;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Mage(25));
        army.addUnit(new Swordsman(25));

        int totalPower = army.calculateTotalPower();
        System.out.println("totalPower= " + totalPower);
    }
}