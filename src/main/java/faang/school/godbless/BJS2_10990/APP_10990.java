package faang.school.godbless.BJS2_10990;

public class APP_10990 {
    public static void main(String[] args) {
        Squad archers = new Squad(82, new Archer(15));
        Squad mages = new Squad(15, new Mage(70));
        Squad arcMages = new Squad(2, new Mage(150));
        Squad swordsmen = new Squad(82, new Swordsman(15));
        Army army = new Army();
        army.addUnit(archers);
        army.addUnit(mages);
        army.addUnit(arcMages);
        army.addUnit(swordsmen);
        int totalPower = army.calculateTotalPower();
        System.out.println("TotalArmyPower is: " + totalPower);
    }
}
