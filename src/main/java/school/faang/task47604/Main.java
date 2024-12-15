package school.faang.task47604;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Archer(50));
        army.addUnit(new Mage(100));
        army.addUnit(new Swordsman(80));
        army.addUnit(new Archer(60));

        try {
            System.out.printf("Сила армии: %d", army.calculateTotalPower());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
