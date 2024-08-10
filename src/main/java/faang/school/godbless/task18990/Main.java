package faang.school.godbless.task18990;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Max", "Heroes of Might");
        hero1.addCreature(new Angel("Alis",  14), 4);
        System.out.println(hero1.getArmy());

        Hero hero2 = new Hero("Alita", "Magic III");
        hero2.addCreature(new Griffin("Grif", 7), 6);
        System.out.println(hero2.getArmy());


    }
}
