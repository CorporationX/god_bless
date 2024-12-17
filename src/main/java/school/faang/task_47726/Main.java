package school.faang.task_47726;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addFighter(new Archer(25));
        army.addFighter(new Swordsman(40));
        army.addFighter(new Mage(50));
        army.addFighter(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println(String.format("Total power of army is: %d", totalPower));
    }
}
