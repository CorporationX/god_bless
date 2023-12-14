package faang.school.godbless.homm;

import java.util.Scanner;

public class Battlefield {
    private final Hero PLAYER_1;
    private final Hero PLAYER_2;
    private final Creature SWORDSMAN = new Swordsman();
    private final Creature DEADMAN = new Deadman();
    private final Creature DRAGON = new Dragon();
    private final Scanner CONSOLE = new Scanner(System.in);
    private final String CHOOSE_UNIT_TEXT = "1 - Swordsman; " + "2 - Deadman; " + "3 - Dragon; ";

    public Battlefield(Hero PLAYER_1, Hero PLAYER_2) {
        this.PLAYER_1 = PLAYER_1;
        this.PLAYER_2 = PLAYER_2;
    }

    public void battle() {
        System.out.println("Players 1 turn");
        buildArmy(PLAYER_1);
        System.out.println("Player 2 turn");
        buildArmy(PLAYER_2);
        System.out.println("Let the battle begin!");

        while (true) {
            System.out.println("Player 1 turn");
            attack(PLAYER_1, PLAYER_2);
            if (endBattle()) {
                break;
            }

            System.out.println("Player 2 turn");
            attack(PLAYER_2, PLAYER_1);
            if (endBattle()) {
                break;
            }
        }
    }

    private void buildArmy(Hero player) {
        System.out.println("Build your army (choose 5 units)");
        System.out.println(CHOOSE_UNIT_TEXT);

        for (int i = 0; i < 5; i++) { // Each player chooses 5 units for their team
            int CHOOSE_UNIT_TEXT = CONSOLE.nextInt();
            switch (CHOOSE_UNIT_TEXT) {
                case 1 -> player.addCreature(SWORDSMAN, 1);
                case 2 -> player.addCreature(DEADMAN, 1);
                case 3 -> player.addCreature(DRAGON, 1);
                default -> {
                    System.out.println("Such unit doesn't exist");
                    if (i > 0) {
                        i--;
                    }
                }
            }
        }

        System.out.println("Your army:");
        // Shows player's team in CONSOLE output
        for (Creature unit : player.getArmy().values()) {
            System.out.println(unit.getName() + ": " + unit.getQuantity());
        }
    }

    private void attack(Hero attacker, Hero enemy) {
        System.out.println("Choose your soldier\n");
        System.out.println(CHOOSE_UNIT_TEXT);

        // choose attacker
        int selectAttackingCreature = CONSOLE.nextInt();
        int damageDealt = 0;
        switch (selectAttackingCreature) {
            // No damage is dealt if hits enemy unit that doesn't exist
            case 1 -> damageDealt = attacker.attackEnemyCreature(SWORDSMAN.getName(), damageDealt, enemy);
            case 2 -> damageDealt = attacker.attackEnemyCreature(DEADMAN.getName(), damageDealt, enemy);
            case 3 -> damageDealt = attacker.attackEnemyCreature(DRAGON.getName(), damageDealt, enemy);
            default -> System.out.println("Sorry, you missed");
        }
        // System.out.println("Who will you attack?");
        // System.out.println(CHOOSE_UNIT_TEXT);

        // choose which creature to attack
//        int selectCreatureToBeAttacked = CONSOLE.nextInt();
//        switch (selectCreatureToBeAttacked) {
//            case 1 -> enemy.removeCreature(SWORDSMAN, 1);
//            case 2 -> enemy.removeCreature(DEADMAN, 1);
//            case 3 -> enemy.removeCreature(DRAGON, 1);
//            default -> System.out.println("Sorry, you missed");
//        }

        // hero's hp decreases depending on creature atk
        attacker.attackEnemyHero(enemy, damageDealt);

        // output of enemy hero current hp and team
        // each attack decreases attacked creature quantity by one
        System.out.println("Enemy HP left: " + enemy.getHp());
        System.out.println("Enemy units left:");

        for (Creature unit : enemy.getArmy().values()) {
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
