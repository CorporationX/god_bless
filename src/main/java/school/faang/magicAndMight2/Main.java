package school.faang.magicAndMight2;

public class Main {
    public static void main(String[] args) {
        Army myArmy = new Army();
        myArmy.addUnit(new Archer());
        myArmy.addUnit(new Swordsman());
        myArmy.addUnit(new Archer());
        myArmy.addUnit(new Mage());
        myArmy.addUnit(new Mage());

        System.out.println(myArmy.calculatePower());
    }
}
