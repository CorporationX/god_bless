package distributed_army_heroes_might_and_magic;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(23));
        army.addUnit(new Archer(23));
        army.addUnit(new Archer(69));
        army.addUnit(new Archer(24));
        army.addUnit(new Mage(12));
        army.addUnit(new Mage(15));
        army.addUnit(new Swordsman(17));

        System.out.println(army.calculateTotalPower());
    }
}
