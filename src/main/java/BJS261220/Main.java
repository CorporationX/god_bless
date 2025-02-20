package BJS261220;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Army army = new Army();
        Squad archers = new Squad();
        archers.addUnit(new Archer(30));
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(32));
        archers.addUnit(new Archer(23));
        archers.addUnit(new Archer(27));

        Squad swordsman = new Squad();
        swordsman.addUnit(new Swordsman(70));
        swordsman.addUnit(new Swordsman(60));
        swordsman.addUnit(new Swordsman(55));
        swordsman.addUnit(new Swordsman(67));
        swordsman.addUnit(new Swordsman(58));

        Squad mage = new Squad();
        mage.addUnit(new Mage(100));
        mage.addUnit(new Mage(115));
        mage.addUnit(new Mage(125));
        mage.addUnit(new Mage(135));

        army.addSquad(swordsman);
        army.addSquad(mage);
        army.addSquad(archers);

        System.out.println("Army power: " + army.calculateTotalPower());
    }
}
