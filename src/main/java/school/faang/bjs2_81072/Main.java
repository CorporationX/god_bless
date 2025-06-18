package school.faang.bjs2_81072;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Army army = new Army();

        Squad archers = new Squad();
        archers.addUnit(new Archer(20));
        archers.addUnit(new Archer(25));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(30));
        swordsmen.addUnit(new Swordsman(35));

        Squad mages = new Squad();
        mages.addUnit(new Mage(10));
        mages.addUnit(new Mage(15));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("total army`s power: " + army.calculateTotalPower());
    }
}
