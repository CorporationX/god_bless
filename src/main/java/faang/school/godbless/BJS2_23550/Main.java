package faang.school.godbless.BJS2_23550;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.add(new Archer(25));
        army.add(new Swordsman(40));
        army.add(new Mage(50));
        army.add(new Mage(20));

        double totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
