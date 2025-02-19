package school.faang.sprint3.bjs2_61177;

public class Main {
    public static void main(String[] args) {
        final Army army = new Army();

        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad swordsman = new Squad();
        swordsman.addUnit(new Swordsman(40));
        swordsman.addUnit(new Swordsman(35));

        Squad mage = new Squad();
        mage.addUnit(new Mage(50));
        mage.addUnit(new Mage(70));

        army.addSquad(archers);
        army.addSquad(swordsman);
        army.addSquad(mage);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}
