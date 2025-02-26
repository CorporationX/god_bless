package school.faang.BJS2_61322;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));
        army.addSquad(archers);

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}
