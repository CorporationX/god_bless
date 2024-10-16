package school.faang.sprint_3.bjs2_35887_distributedArmyHomm;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Mage());

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
