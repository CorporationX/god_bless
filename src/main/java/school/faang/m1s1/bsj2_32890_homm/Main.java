package school.faang.m1s1.bsj2_32890_homm;

public class Main {

    public static void main(String[] args) {
        Battlefield battle = new Battlefield();

        Hero artas = new Hero("Artas", "Humans", 0, 1);
        artas.addCreature(new Pikeman(), 150);
        artas.addCreature(new Angel(), 5);
        artas.addCreature(new Peasant(), 500);

        artas.displayArmy();

        System.out.println();

        Hero gremlin = new Hero("Gremlin", "Goblintown", 0, 1);
        gremlin.addCreature(new Skeleton(), 100);
        gremlin.addCreature(new Swordsman(), 20);
        gremlin.addCreature(new Pikeman(), 150);
        gremlin.addCreature(new Angel(), 200);

        gremlin.displayArmy();

        gremlin.removeCreature("Angel");

        battle.fight(artas, gremlin);
    }
}

