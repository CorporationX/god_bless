package faang.school.godbless.task18990;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Max", "Unicorn", 5, 6);
        hero.addCreature(new Angel("Alis", 2, 5, 10, 3, 14), 3);
        System.out.println(hero.getArmy());


    }
}
