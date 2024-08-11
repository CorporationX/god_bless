package faang.school.godbless.javahashmap.task7;

public class Main {
    public static void main(String[] args) {
        Hero firstHero = new Hero("GhulamMiller", "dwarf");
        firstHero.addCreature(new Angel(), 5);
        firstHero.addCreature(new Griffin(), 18);
        firstHero.addCreature(new Pikeman(), 40);
        firstHero.addCreature(new Swordman(), 10);

        Hero secondHero = new Hero("AlexanderZou", "undead");
        secondHero.addCreature(new Angel(), 10);
        secondHero.addCreature(new Griffin(), 11);
        secondHero.addCreature(new Pikeman(), 30);
        secondHero.addCreature(new Swordman(), 25);

        System.out.println(firstHero.getArmy());
        System.out.println(secondHero.getArmy());
        BattleField battleField = new BattleField(firstHero, secondHero);
        System.out.println("Победитель " + battleField.battle());
    }
}
