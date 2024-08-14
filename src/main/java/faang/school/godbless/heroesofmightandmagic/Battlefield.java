package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero hero;
    private Hero enemy;

    public String battle() {
        while (hero.hasArmy() && enemy.hasArmy()) {
            hero.fight(enemy);
        }

        if (!hero.getArmy().isEmpty()) {
            return "Победил: " + hero.getName();
        } else if (!enemy.getArmy().isEmpty()) {
            return "Победил: " + enemy.getName();
        } else {
            return "В неравном бою слегли оба!";
        }
    }
}
