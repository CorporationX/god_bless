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
            if (endBattle()) {
                break;
            }
            PLAYER_2.attackEnemyArmy(PLAYER_1);
            if (endBattle()) {
                break;
            }
        }
    }

    private boolean endBattle() {
        if (PLAYER_1.getArmy().isEmpty() || PLAYER_1.getHp() <= 0) {
            System.out.println(PLAYER_2.getName() + " victory!");
            return true;
        } else if (PLAYER_2.getArmy().isEmpty() || PLAYER_2.getHp() <= 0) {
            System.out.println(PLAYER_1.getName() + " victory!");
            return true;
        } else {
            return false;
        }
    }
}
