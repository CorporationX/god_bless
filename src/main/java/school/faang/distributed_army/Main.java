package school.faang.distributed_army;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));   //counting in thread 1
        army.addUnit(new Swordsman(40));//counting in thread 2
        army.addUnit(new Mage(50));     //counting in thread 3
        army.addUnit(new Mage(20));     //counting in thread 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}