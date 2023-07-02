package faang.school.godbless.sprint4.heroesOfMightAndMagic.classes;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Swordsman(20));
        army.addUnit(new Archer(20));
        army.addUnit(new Mage(15));
        army.addUnit(new Archer(10));
        System.out.println(army.calculateTotalPower());
    }
}
