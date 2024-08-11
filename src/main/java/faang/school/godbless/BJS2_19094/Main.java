package faang.school.godbless.BJS2_19094;

public class Main {
    public static void main(String[] args) {
        Hero artem = new Hero("Artem", "Uber");
        Hero tigran = new Hero("Tigran", "Yandex");

        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        artem.addCreature(pikeman, 50);
        artem.addCreature(griffin, 25);
        artem.addCreature(angel, 10);

        artem.removeCreature(angel, 10);

        tigran.addCreature(swordman, 30);
        tigran.addCreature(griffin, 20);
        tigran.addCreature(angel, 5);

        System.out.printf("Армия %s:%n", artem.getName());
        artem.getArmy().forEach((name, unit) ->
                System.out.println(unit.getCreature().getName() + " x " + unit.getQuantity())
        );

        System.out.printf("Армия %s:%n", tigran.getName());
        tigran.getArmy().forEach((name, unit) ->
                System.out.println(unit.getCreature().getName() + " x " + unit.getQuantity())
        );

        Battlefield battlefield = new Battlefield(artem, tigran);
        String result = battlefield.battle();
        System.out.printf("Результат боя: %s%n", result);
    }
}
