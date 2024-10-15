package school.faang.firstStream.BJS2_32875;

public class Battlefield {
    private Army assembleHeroArmy(Hero hero) {
        int totalLevel = 0;
        int totalDamage = 0;
        int totalProtection = 0;
        int totalHp = 0;

        for (var entry : hero.getArmy().entrySet()) {
            totalLevel += entry.getKey().getLevel() * entry.getValue();
            totalDamage += entry.getKey().getDamage() * entry.getValue();
            totalProtection += entry.getKey().getProtection() * entry.getValue();
            totalHp += entry.getKey().getHp() * entry.getValue();
        }

        return new Army(hero.getFraction(), totalLevel, totalDamage,
                totalProtection, totalHp);
    }

    public void fight(Hero attacker, Hero defender) {
        Army armyAttacker = assembleHeroArmy(attacker);
        Army armyDefender = assembleHeroArmy(defender);
        battle(armyAttacker, armyDefender);
    }

    private void battle(Army attacker, Army defender) {
        int round = 1;
        System.out.println("Battle begins");

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
}
