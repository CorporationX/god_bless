package faang.school.godbless.multithreading.parallelism.heroesArmy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addCreatureInArmy(new Archer(25));
        army.addCreatureInArmy(new Swordman(40));
        army.addCreatureInArmy(new Mage(50));
        army.addCreatureInArmy(new Mage(20));

        System.out.println("Total army power: " + army.calculateTotalPower(army.getListArmy()));
    }
}
