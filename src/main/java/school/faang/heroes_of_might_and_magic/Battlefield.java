package school.faang.heroes_of_might_and_magic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Battlefield {
    private final  Hero MY_HERO;
    private final  Hero ENEMY_HERO;

    public Battlefield(Hero MY_HERO, Hero ENEMY_HERO) {
        this.MY_HERO = MY_HERO;
        this.ENEMY_HERO = ENEMY_HERO;
    }

    public void batle() {


    }

    public void getAttackUnits(Creature creature, int quantity) {
        for (Map.Entry<Creature, Integer> entry : ENEMY_HERO.getArmy().entrySet()) {
            Creature creature1 = entry.getKey();
        }
    }

    public void show(Creature creature, int quantity) {
        System.out.println("Убиты: " + creature.getName() + " в количестве " + quantity);
    }

}
