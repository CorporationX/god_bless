package faang.school.godbless.BJS2_7918;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Hero battle() {

        int hero1Damage = 0;
        int hero2Damage = 0;
        Hero winner;


        for (var heroSoldier : hero1.getHeroArmy()) {
            hero1Damage += heroSoldier.getDamage();
        }

        for (var heroSoldier : hero2.getHeroArmy()) {
            hero2Damage += heroSoldier.getDamage();
        }

        if (hero1Damage > hero2Damage) {
            winner = hero1;
        } else if (hero1Damage < hero2Damage) {
            winner = hero2;
        } else {
            winner = null;
        }

        return winner;
    }
}
