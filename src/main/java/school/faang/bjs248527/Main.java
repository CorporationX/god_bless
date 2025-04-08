package school.faang.bjs248527;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(233));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
    }
}