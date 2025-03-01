package school.faang.heroes.of.might.and.magic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnit(new Archer(40));
        archers.addUnit(new Archer(40));
        archers.addUnit(new Archer(40));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(50));
        swordsmen.addUnit(new Swordsman(50));
        swordsmen.addUnit(new Swordsman(50));

        Squad mages = new Squad();
        mages.addUnit(new Mage(20));
        mages.addUnit(new Mage(20));
        mages.addUnit(new Mage(20));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}