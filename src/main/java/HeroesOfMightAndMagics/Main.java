package HeroesOfMightAndMagics;

public class Main {
    public static void main(String[] args) throws Exception {
        Army army = new Army();

        army.addUnit(new Mage(235));
        army.addUnit(new Archer(545));
        army.addUnit(new Swordsman(345));

        System.out.println(army.calculateTotalPower());
    }
}
