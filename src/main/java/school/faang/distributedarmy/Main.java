package school.faang.distributedarmy;

public class Main {
    public static void main(String[] args) throws Exception {
        Army myArmy = new Army();
        myArmy.addUnit(new Archer(50));
        myArmy.addUnit(new Mage(30));
        myArmy.addUnit(new Archer(20));
        myArmy.addUnit(new Swordsman(90));

        System.out.println("Result: " + myArmy.calculateTotalPower());
    }
}
