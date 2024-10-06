package school.faang.heroes;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Герой1", "Орда", 120, 23);
        Hero hero2 = new Hero("Герой2", "Альянс", 120, 23);

        hero1.addCreature(new Pikeman(), 120);
        hero1.addCreature(new Griffin(), 50);
        hero1.addCreature(new Angel(), 40);

        hero2.addCreature(new Swordman(), 500);
        hero2.addCreature(new Griffin(), 50);
        hero2.addCreature(new Angel(), 40);

        System.out.println("Битва 1, победитель: ");
        BattleField battleField = new BattleField(hero1, hero2);
        System.out.println(battleField.battle());

        System.out.println("Битва 2, победитель: ");
        hero2.removeCreature(new Swordman(), 500);
        System.out.println(battleField.battle());

        System.out.println("Армия второго героя");
        System.out.println(hero2.getCreatures());
    }
}
