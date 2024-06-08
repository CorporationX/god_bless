package faang.school.godbless.heroes_of_might_and_magic;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Battlefield {
    private Hero first;
    private Hero second;

    public void battle() {
        int firstHeroTotalStats =
                getAllDamage(first.getArmy()) + getAllLevel(first.getArmy()) + getAllDefence(first.getArmy()) + getAllSpeed(first.getArmy());
        firstHeroTotalStats += firstHeroTotalStats + (first.getExperience() * first.getLevel());

        int secondHeroTotalStats =
                getAllDamage(second.getArmy()) + getAllLevel(second.getArmy()) + getAllDefence(second.getArmy()) + getAllSpeed(second.getArmy());
        secondHeroTotalStats += secondHeroTotalStats + (second.getExperience() * second.getLevel());

        if (firstHeroTotalStats > secondHeroTotalStats) {
            System.out.println(first + " won!");
        } else if (secondHeroTotalStats > firstHeroTotalStats) {
            System.out.println(second + " won!");
        } else {
            System.out.println("Draw!");
        }
    }

    private int getAllDamage(Map<Creature, Integer> map) {
        int res = 0;
        for (Map.Entry<Creature, Integer> entry : map.entrySet()) {
            res += entry.getKey().getDamage() * entry.getValue();
        }
        return res;
    }

    private int getAllLevel(Map<Creature, Integer> map) {
        int res = 0;
        for (Map.Entry<Creature, Integer> entry : map.entrySet()) {
            res += entry.getKey().getLevel() * entry.getValue();
        }
        return res;
    }

    private int getAllDefence(Map<Creature, Integer> map) {
        int res = 0;
        for (Map.Entry<Creature, Integer> entry : map.entrySet()) {
            res += entry.getKey().getDefence() * entry.getValue();
        }
        return res;
    }

    private int getAllSpeed(Map<Creature, Integer> map) {
        int res = 0;
        for (Map.Entry<Creature, Integer> entry : map.entrySet()) {
            res += entry.getKey().getSpeed() * entry.getValue();
        }
        return res;
    }
}
