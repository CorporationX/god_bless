package school.faang.s3_multi_heroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(25));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(40));

        Squad mages = new Squad();
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(50));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.printf("Общая сила армии: %d%n", army.calculateTotalPower());
    }
}
