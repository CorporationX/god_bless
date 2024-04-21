package faang.school.godbless.heroes_of_mm;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addCreature(new Archer(25));
        army.addCreature(new Swordsman(40));
        army.addCreature(new Mage(50));
        army.addCreature(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии героя: " + totalPower);
    }
}
