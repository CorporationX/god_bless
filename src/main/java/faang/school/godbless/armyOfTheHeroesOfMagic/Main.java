package faang.school.godbless.armyOfTheHeroesOfMagic;

public class Main {
    public static void main(String[] args) {

        Army army = new Army();

        // Добавляем различные подразделения в армию
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(90));
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(90));
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(90));
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(90));

        double totalPower = army.calculateTotalPower();
        System.out.println("Total Army Power: " + totalPower);

    }
}
