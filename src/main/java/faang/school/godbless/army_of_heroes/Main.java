package faang.school.godbless.army_of_heroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Archer(100));
        army.addUnit(new Mage(250));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power: " + totalPower);
    }
}

