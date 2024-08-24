package faang.school.godbless.sprint.three.heroes;

public class App {
    public static void main(String... args) {
        Army army = new Army();
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(20));
        army.addUnit(new Mage(5));
        army.addUnit(new Mage(5));
        army.addUnit(new Mage(5));
        army.addUnit(new Swordsman(4));
        army.addUnit(new Archer(5));
        army.addUnit(new Archer(3));
        army.addUnit(new Mage(1));



        try {
            System.out.printf("Total army amount %d%n", army.calculateTotalPower());
            System.out.println("Finish");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
