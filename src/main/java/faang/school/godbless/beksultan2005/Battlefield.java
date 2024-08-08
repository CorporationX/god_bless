package faang.school.godbless.beksultan2005;

import java.util.Map;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public void battle() {
        float power1 = 0, power2 = 0;
        for (Map.Entry<Creature, Integer> entry : hero1.getFaction().entrySet()) {
            power1 += (entry.getKey().getDamage() * entry.getValue());
        }
        for (Map.Entry<Creature, Integer> entry : hero2.getFaction().entrySet()) {
            power2 += (entry.getKey().getDamage() * entry.getValue());
        }
        power1 = power1 * hero1.getExperience() / 10 * hero1.getLevel();
        power2 = power2 * hero2.getExperience() / 10 * hero1.getLevel();
        if (power1 > power2) {
            System.out.println(hero1.getName() + " win!");
        } else if (power2 > power1) {
            System.out.println(hero2.getName() + " win!");
        } else {
            System.out.println("There is no winner!");
        }
    }
}
