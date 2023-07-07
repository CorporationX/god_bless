package faang.school.godbless.Multithreading.ParallelismAndThread.task05_heroes;


import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> unitList = List.of(
                new Archer(25), new Swordsman(40), new Mage(50),
                new Archer(27), new Swordsman(42), new Mage(49),
                new Archer(26), new Swordsman(41), new Mage(51));

        Army army = new Army(unitList);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power army = "+ totalPower);
    }
}
