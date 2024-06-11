package faang.school.godbless.hashmaps.heroes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hero heroLeft = new Hero("Герой слева", "Пики", "Middle", 1);
        Hero heroRight = new Hero("Герой справа", "Бубны", "Middle", 1);

        heroLeft.addCreature(new Pikeman("Pikeman", 1));
        heroLeft.addCreature(new Angel("Angel", 2));

        heroRight.addCreature(new Griffin("Griffin", 2));
        heroRight.addCreature(new Swordman("Swordman", 1));


        Battlefield battlefield = new Battlefield(Arrays.asList(heroLeft, heroRight));
        battlefield.battle();
    }
}
