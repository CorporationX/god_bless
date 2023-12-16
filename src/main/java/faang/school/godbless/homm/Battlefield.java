package faang.school.godbless.homm;

public class Battlefield {
    private final Hero PLAYER_1;
    private final Hero PLAYER_2;

    public Battlefield(Hero PLAYER_1, Hero PLAYER_2) {
        this.PLAYER_1 = PLAYER_1;
        this.PLAYER_2 = PLAYER_2;
    }

    public void battle() {
        PLAYER_1.buildArmy();
        PLAYER_2.buildArmy();

        while (true) {
            attack(PLAYER_1, PLAYER_2);
            if (endBattle()) {
                break;
            }
            attack(PLAYER_2, PLAYER_1);
            if (endBattle()) {
                break;
            }
        }
    }

    private void attack(Hero attacker, Hero enemy) {
        attacker.attackEnemyArmy(enemy);
        System.out.println(enemy.getName() + " HP left: " + enemy.getHp());
        System.out.println(enemy.getName() + " units left:");

        for (Creature unit : enemy.getArmy()) {
            System.out.println(unit.getName() + ": " + unit.getQuantity());
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
