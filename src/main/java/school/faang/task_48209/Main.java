package school.faang.task_48209;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addFighter(new Archer(35));
        army.addFighter(new Swordsman(40));
        army.addFighter(new Mage(50));
        army.addFighter(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
