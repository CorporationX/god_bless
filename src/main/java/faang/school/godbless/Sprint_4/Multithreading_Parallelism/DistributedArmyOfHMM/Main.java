package faang.school.godbless.Sprint_4.Multithreading_Parallelism.DistributedArmyOfHMM;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(60));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Mage(10));

        System.out.println(army.calculateTotalPower());
    }
}
