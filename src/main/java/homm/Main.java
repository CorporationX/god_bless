package homm;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Mage(50));
        army.addUnit(new Swordsman(20));
        army.addUnit(new Mage(75));

        System.out.println("Total power: " + army.totalPower());
    }
}
