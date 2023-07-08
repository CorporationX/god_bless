package faang.school.godbless.distributedArmy;
public class App {
    public static void main(String[] args) {
        Army army = new Army();
        army.addArcher(new Archer(25));
        army.addSwordsman(new Swordsman(40));
        army.addMage(new Mage(50));
        army.addMage(new Mage(20));
        army.addMage(new Mage(35));
        army.addArcher(new Archer(57));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
