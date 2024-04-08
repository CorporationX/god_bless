package faang.school.godbless.BJS24717;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("ГеройКрутой", "Нагибатор");
        Hero hero2 = new Hero("ГеройТупой", "Прогибатор");

        hero1.addCreature(new Pikeman(), 1);
        hero1.addCreature(new Swordman(), 5);

        hero2.addCreature(new Pikeman(), 8);
        hero2.addCreature(new Angel(), 2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        System.out.println(hero1.getArmy());
        System.out.println(hero2.getArmy());
        Hero winner = battlefield.battle();
        System.out.println("Победил: " + winner.getName());

        System.out.println("----------------------------");
        hero2.removeCreature(new Angel(), 2);
        hero2.removeCreature(new Pikeman(), 4);
        System.out.println(hero1.getArmy());
        System.out.println(hero2.getArmy());
        Hero winner1 = battlefield.battle();
        System.out.println("Победил: " + winner1.getName());

    }
}
