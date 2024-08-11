package faang.school.godbless.task18990;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Max", "Heroes of Might");
        hero1.addCreature(new Angel("Alis", 2, 2,  8, 2,6), 2);
        hero1.addCreature(new Pikeman("Pike", 3, 6, 4, 5,8), 3);
        System.out.println(hero1.getArmy());

        Hero hero2 = new Hero("Alita", "Magic III");
        hero2.addCreature(new Griffin("Grif", 4, 9, 1, 5,7), 3);
        hero2.addCreature(new Swordman("Sword", 5,10, 1, 1,7), 2);
        System.out.println(hero2.getArmy());

        Battlefield battlefield = new Battlefield();
        System.out.println(" The winner is " + battlefield.battle(hero1, hero2));

        System.out.println(hero1.getExperience());
        System.out.println(hero1.getLevel());
        System.out.println(hero2.getExperience());
        System.out.println(hero2.getLevel());

    }
}
