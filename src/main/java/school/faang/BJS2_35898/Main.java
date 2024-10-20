package school.faang.BJS2_35898;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addUnit(new Archer(29));
        army.addUnit(new Swordsman(43));
        army.addUnit(new Mage(58));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая мощность армии: " + totalPower);
    }
}
