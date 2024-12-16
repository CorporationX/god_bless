package school.faang.bjs247633;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addFighter(new Archer(30));
        army.addFighter(new Swordsman(50));
        army.addFighter(new Mage(60));

        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
