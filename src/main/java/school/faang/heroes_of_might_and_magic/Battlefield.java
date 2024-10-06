package school.faang.heroes_of_might_and_magic;

import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    private final static Hero MY_HERO;
    private final static Hero ENEMY_HERO;
    //<существа, кол-во существ>
    private static final Map<Creature, Integer> MY_ARMY = new HashMap<>();
    private static final Map<Creature, Integer> ENEMY_ARMY = new HashMap<>();

    static {
        MY_HERO = new Hero("Maksimus", "Cyclops", 550, 8);
        ENEMY_HERO = new Hero("Cyclop", "Cyclops", 330, 4);
        MY_ARMY.put(new Griffin("Griff"), 15);
        MY_ARMY.put(new Swordman("Snow"), 25);
        MY_ARMY.put(new Pikeman("Rocki"), 90);
        MY_ARMY.put(new Angel("Fire"), 10);
        ENEMY_ARMY.put(new Griffin("Zloy"), 150);
    }

    public static void batle() {
        int bonusMyHero = MY_HERO.getExperience();
        int bonusEnemyHero = ENEMY_HERO.getExperience();


    }

}
