package faang.school.godbless.heroesofmightandmagic;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero", "HeroFraction", 1, 1, null);
        Hero enemy = new Hero("Enemy", "EnemyFraction", 2, 1, null );

        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordsman = new Swordsman();
        Creature angel = new Angel();

        hero.addCreature(pikeman, 12);
        hero.addCreature(griffin, 3);
        hero.addCreature(swordsman, 7);
        hero.addCreature(angel, 9);
        // ангелы у героя:
        // 7 -> побеждает Enemy
        // 8 -> "побеждают оба"
        // 9 -> побеждает Hero

        enemy.addCreature(pikeman, 14);
        enemy.addCreature(griffin, 4);
        enemy.addCreature(swordsman, 8);
        enemy.addCreature(angel, 5);

        Battlefield battlefield = new Battlefield(hero, enemy);

        System.out.println(battlefield.battle());
    }
}
