package school.faang.heroes;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(1, "Jhon"));
        army.addUnit(new Archer(2, "Kate"));
        army.addUnit(new Archer(3, "Anna"));
        army.addUnit(new Mage(3, "Mag1"));
        army.addUnit(new Mage(4, "Mag2"));
        army.addUnit(new Mage(5, "Mag3"));
        army.addUnit(new Swordsman(6, "Mag1"));
        army.addUnit(new Swordsman(7, "Mag2"));
        army.addUnit(new Swordsman(8, "Mag3"));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power of army: " + totalPower);
    }
}
