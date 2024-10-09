package school.faang.heroes_of_might_and_magic;

import java.util.Map;

public class Battlefield {
    private final  Hero MY_HERO;
    private final  Hero ENEMY_HERO;

    public Battlefield(Hero MY_HERO, Hero ENEMY_HERO) {
        this.MY_HERO = MY_HERO;
        this.ENEMY_HERO = ENEMY_HERO;
    }

    public void battle() {
        int myAttack = getAttackUnits(MY_HERO.getArmy());
        int enemyAttack = getAttackUnits(ENEMY_HERO.getArmy());
        if (myAttack > enemyAttack) {
            System.out.println("Мой герой победил! его имя " + MY_HERO.getName());
        } else if (enemyAttack > myAttack) {
            System.out.println("Победила армия Врага: " + ENEMY_HERO.getName());
        } else {
            System.out.println("Победителей нет, есть только побежденные");
        }
    }

    public Integer getAttackUnits(Map<Creature, Integer> armors) {
        int attack = 0;
        for (Map.Entry<Creature, Integer> entry : armors.entrySet()) {
            Creature creature1 = entry.getKey();
            attack += creature1.getDamage() * entry.getValue();
        }
        return attack;
    }
}
