package school.faang.bjs248536;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(100));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(20));

        try {
            int totalPower = army.calculateTotalPower();
            System.out.println("Total power army: " + totalPower);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
