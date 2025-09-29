package school.faang.heroes_of_might_and_magic;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        Squad archers = new Squad("Лучники");
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad swordsmen = new Squad("Мечники");
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        Squad mages = new Squad("Маги");
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(45));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}