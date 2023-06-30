package faang.school.godbless.task.DistributedArmy;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addSoldier(new Archer(25));
        army.addSoldier(new Swordsman(40));
        army.addSoldier(new Mage(50));
        army.addSoldier(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
