package faang.school.godbless.homm.battle;

import faang.school.godbless.homm.hero.Hero;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private final Hero PLAYER_1;
    private final Hero PLAYER_2;

    public void battle() {
        PLAYER_1.buildArmy();
        PLAYER_2.buildArmy();

        while (true) {
            PLAYER_1.attackEnemyArmy(PLAYER_2);
            if (endBattle(PLAYER_1, PLAYER_2)) {
                break;
            }
            PLAYER_2.attackEnemyArmy(PLAYER_1);
            if (endBattle(PLAYER_2, PLAYER_1)) {
                break;
            }
        }
    }

    private boolean endBattle(Hero hero, Hero enemy) {
        if (enemy.getArmy().isEmpty() || enemy.getHp() <= 0) {
            System.out.println(hero.getName() + " victory!");
            return true;
        }

        return false;
    }
}
