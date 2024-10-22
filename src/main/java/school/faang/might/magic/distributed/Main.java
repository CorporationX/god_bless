package school.faang.might.magic.distributed;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(
                new Archer(25),
                new Swordsman(40),
                new Mage(50),
                new Mage(20),
                new Swordsman(40),
                new Mage(20),
                new Swordsman(40),
                new Archer(25),
                new Archer(25)
        );

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
