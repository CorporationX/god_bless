package faang.school.godbless.homm;

public class Main {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        Hero hero1 = new Hero("Arthas", "Alliance");
        Hero hero2 = new Hero("Nerzhul", "Litches");

        Creature angel = new Angel("Angel", 0);
        Creature griffin = new Griffin("Griffin", 0);
        Creature pikeman = new Pikeman("Pikeman", 0);
        Creature swordman = new Swordman("Swordman", 0);

        hero1.addCreature(swordman, 10);
        hero2.addCreature(pikeman, 10);

        hero2.getArmy();
        hero1.getArmy();

        hero1.removeCreature(swordman, 5);
        hero1.addCreature(angel, 5);

        hero1.getArmy();

        hero1.addCreature(griffin, 10);

        System.out.println("В битве побеждает " + battlefield.battle(hero1, hero2).getName());
    }
    //надо исправить способ подсчета выигравшей стороны, ищменить структуру армии со списка на хэшмапу
}
