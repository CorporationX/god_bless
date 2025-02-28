package school.faang.task_61438;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        Squad mages = new Squad();
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(45));

        Army army = new Army();

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}