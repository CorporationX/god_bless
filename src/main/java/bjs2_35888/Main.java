package bjs2_35888;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.recruiting(new Archer(20));
        army.recruiting(new Swordsman(50));
        army.recruiting(new Mage(30));

        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
