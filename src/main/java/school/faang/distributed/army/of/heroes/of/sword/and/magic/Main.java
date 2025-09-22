package school.faang.distributed.army.of.heroes.of.sword.and.magic;

import java.util.List;

public class Main {
    private static void testOne() throws InterruptedException {
        Squad archers = new Squad("Лучники", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Мечники", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Маги", List.of(new Mage(50), new Mage(45)));

        Army army = new Army();

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);


        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

    private static void testTwo() throws InterruptedException {
        final Army army = new Army();
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        army.addSquad(archers);
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }

    public static void main(String[] args) throws InterruptedException {
        testOne();
        testTwo();
    }
}
