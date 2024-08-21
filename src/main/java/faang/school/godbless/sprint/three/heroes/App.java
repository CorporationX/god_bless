package faang.school.godbless.sprint.three.heroes;

public class App {
    public static void main(String... args) {
        Army army = new Army();
        army.addUnit(new Archer(10));
        army.addUnit(new Swordsman(15));
        army.addUnit(new Mage(12));
        army.addUnit(new Archer(8));

        try {
            System.out.printf("Total army amount %d%n", army.calculateTotalPower());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
