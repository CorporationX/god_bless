package school.faang.heroesmandm;

public class Main {

    public static void main(String[] args) {
        Hero first = new Hero("Alliance Warrior", "Alliance", 0, 1);
        Hero second = new Hero("Horde Warrior", "Horde", 0, 1);

        first.addCreature(new Angel(), 40);
        first.addCreature(new Pikeman(), 200);
        first.addCreature(new Griffin(), 50);

        second.addCreature(new Angel(), 40);
        second.addCreature(new Griffin(), 50);
        second.addCreature(new Swordman(), 500);

        System.out.println("Сражение началось... победитель: ");
        Battlefield battleField = new Battlefield(first, second);
        System.out.println(battleField.battle().getName());
    }
}