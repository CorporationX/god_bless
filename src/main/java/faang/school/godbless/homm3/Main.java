package faang.school.godbless.homm3;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Arthur", "Castle", 1);
        Hero hero2 = new Hero("Morgana", "Inferno", 1);

        // Создаем существ
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        // Добавляем существ в армии героев
        hero1.addCreature(pikeman, 10);
        hero1.addCreature(griffin, 5);
        hero2.addCreature(swordman, 8);
        hero2.addCreature(angel, 3);

        // Создаем бой
        BattleField battlefield = new BattleField();
        String winner = battlefield.battle(hero1, hero2);

        System.out.println(winner);///
    }
}
