package faang.school.godbless.BJS2_18922;

public class Main {

    public static void main(String[] args) {
        Hero ciel = new Hero("Ciel", "Conflux", 16, 16993);
        Hero shakti = new Hero("Shakri", "Dungeon", 15, 15422);

        ciel.addCreature(new Griffin(), 10);
        ciel.addCreature(new Griffin(), 13);
        shakti.addCreature(new Angel(), 2);
        System.out.println(ciel.getArmy());
        System.out.println(Battlefield.battle(ciel, shakti));
    }
}
