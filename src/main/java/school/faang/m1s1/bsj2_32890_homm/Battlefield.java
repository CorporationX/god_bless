package school.faang.m1s1.bsj2_32890_homm;

public class Battlefield {

    public void fight(Hero heroAttacker, Hero heroDefender) {
        Army armyAttacker = assembleHeroArmy(heroAttacker);
        Army armyDefender = assembleHeroArmy(heroDefender);

        battle(armyAttacker, armyDefender);
    }

    private void battle(Army attacker, Army defender) {
        int round = 1;
        System.out.printf("Battle begins. %s vs %s\n", attacker.getName(), defender.getName());

        while (attacker.getHp() > 0 || defender.getHp() > 0) {
            System.out.printf("\nRound %d\n", round);
            int damage = attacker.strikeEnemy(defender);
            defender.setHp(defender.getHp() - damage);
            System.out.printf("%s (HP left: %d) makes %d damage. %s (HP left: %d)\n",
                    attacker.getName(), attacker.getHp(), damage, defender.getName(), defender.getHp());

            if (defender.getHp() <= 0) {
                defender.setHp(0);
                System.out.printf("\n%s wins\n", attacker.getName());
                break;
            }
            damage = defender.strikeEnemy(attacker);
            attacker.setHp(attacker.getHp() - damage);
            System.out.printf("%s (HP left: %d) makes %d damage. %s (HP left: %d left)\n",
                    defender.getName(), defender.getHp(), damage, attacker.getName(), attacker.getHp());

            if (attacker.getHp() <= 0) {
                System.out.printf("\nDefender %s wins\n", defender.getName());
                break;
            }
            round++;
        }
    }
    private Army assembleHeroArmy(Hero hero) {
        int attackAll = 0;
        int defenceAll = 0;
        int speedAll = 0;
        int damageAll = 0;
        int hpAll = 0;
        for (var entry : hero.getArmy().entrySet()) {
            attackAll += entry.getKey().getAttack() * entry.getValue();
            defenceAll += entry.getKey().getDefence() * entry.getValue();
            speedAll += entry.getKey().getSpeed() * entry.getValue();
            damageAll += entry.getKey().getDamage() * entry.getValue();
            hpAll += entry.getKey().getHp() * entry.getValue();
        }
        return new Army (hero.getName(), hero.getLevel(), attackAll,
                defenceAll, speedAll, damageAll, hpAll);
    }
}
