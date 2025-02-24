package school.faang;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad();
        archers.addUnit(new Archer(40));
        archers.addUnit(new Archer(45));

        Squad mages = new Squad();
        mages.addUnit(new Mage(20));
        mages.addUnit(new Mage(30));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(52));
        swordsmen.addUnit(new Swordsman(55));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(mages);
        army.addSquad(swordsmen);

        System.out.printf("Общая сила армии: %s\n", army.calculateTotalPower());
    }
}
