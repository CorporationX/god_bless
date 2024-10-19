package school.faang.Mnogopotochka.ParallelismThread.BJS2_35893;

public class Main {
    static Army army = new Army();
    public static void main(String[] args) throws InterruptedException {
        addUnit(new Archer(25));
        addUnit(new Archer(21));
        addUnit(new Archer(23));
        addUnit(new Swordman(37));
        addUnit(new Swordman(40));
        addUnit(new Mage(50));
        addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

    public static void addUnit(Unit unit){
        army.addUnit(unit);
    }
}
