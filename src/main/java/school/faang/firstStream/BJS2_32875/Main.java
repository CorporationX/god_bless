package school.faang.firstStream.BJS2_32875;

public class Main {
    public static void main(String[] args) {
        Battlefield battle = new Battlefield();

        Hero alMighty = new Hero("Tashinori", "Heroes", 100, 100);
        alMighty.addCreature(new Pikeman(), 350);
        alMighty.addCreature(new Swordman(), 500);
        alMighty.addCreature(new Griffin(), 100);
        alMighty.addCreature(new Angel(), 5);
        alMighty.printArmy();
        System.out.println();

        Hero allForOne = new Hero("Shigaraki", "League of Villains", 100, 100);
        alMighty.addCreature(new Pikeman(), 450);
        alMighty.addCreature(new Swordman(), 400);
        alMighty.addCreature(new Griffin(), 140);
        alMighty.addCreature(new Angel(), 3);
        alMighty.printArmy();
        alMighty.removeCreature("Angel");

        battle.fight(alMighty, allForOne);
    }
}
