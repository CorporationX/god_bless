package faang.school.godbless.BJS223663;

public class App {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Pudge(60));
        army.addUnit(new Dragon(100));

        int totalPower = army.calculateTotalPower();

        System.out.println("Total army power: " + totalPower);
    }
}
