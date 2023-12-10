package faang.school.godbless.homm;

import java.util.Scanner;

public class Battlefield {
    private final Hero player1;
    private final Hero player2;
    private final Creature swordsman = new Swordsman();
    private final Creature deadman = new Deadman();
    private final Creature dragon = new Dragon();
    private final Scanner console = new Scanner(System.in);
    String chooseUnitText = new StringBuilder
            ("1 - Swordsman; ")
            .append("2 - Deadman; ")
            .append("3 - Dragon; ")
            .toString();

    public Battlefield(Hero player1, Hero player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void battle() {
        System.out.println("Players 1 turn");
        buildArmy(player1);
        System.out.println("Player 2 turn");
        buildArmy(player2);
        System.out.println("Let the battle begin!");

        while (true) {
            System.out.println("Player 1 turn");
            attack(player1, player2);
            if (endBattle()) {
                break;
            }

            System.out.println("Player 2 turn");
            attack(player2, player1);
            if (endBattle()) {
                break;
            }
        }
    }

    private void buildArmy(Hero player) {
        System.out.println("Build your army (choose 5 units)");
        System.out.println(chooseUnitText);

        for (int i = 0; i < 5; i++) { // Each player chooses 5 units for their team
            int chooseUnitText = console.nextInt();
            switch (chooseUnitText) {
                case 1 -> player.addCreature(swordsman, 1);
                case 2 -> player.addCreature(deadman, 1);
                case 3 -> player.addCreature(dragon, 1);
                default -> {
                    System.out.println("Such unit doesn't exist");
                    if (i > 0) {
                        i--;
                    }
                }
            }
        }

        System.out.println("Your army:");
        // Shows player's team in console output
        for (Creature unit : player.getArmy().values()) {
            System.out.println(unit.name + ": " + unit.quantity);
        }
    }

    private void attack(Hero attacker, Hero enemy) {
        System.out.println("Choose your soldier\n");
        System.out.println(chooseUnitText);

        // choose attacker
        int selectAttackingCreature = console.nextInt();
        int damageDealt = 0;
        switch (selectAttackingCreature) {
            // No damage is dealt if hits enemy unit that doesn't exist
            case 1 -> damageDealt = attacker.getArmy().containsKey("Swordsman")
                    ? attacker.getArmy().get("Swordsman").getDamage()
                    : 0;
            case 2 -> damageDealt = attacker.getArmy().containsKey("Deadman")
                    ? attacker.getArmy().get("Deadman").getDamage()
                    : 0;
            case 3 -> damageDealt = attacker.getArmy().containsKey("Dragon")
                    ? attacker.getArmy().get("Dragon").getDamage()
                    : 0;
            default -> System.out.println("Sorry, you missed");
        }
        System.out.println("Who will you attack?");
        System.out.println(chooseUnitText);

        // choose which creature to attack
        int selectCreatureToBeAttacked = console.nextInt();
        switch (selectCreatureToBeAttacked) {
            case 1 -> enemy.removeCreature(swordsman, 1);
            case 2 -> enemy.removeCreature(deadman, 1);
            case 3 -> enemy.removeCreature(dragon, 1);
            default -> System.out.println("Sorry, you missed");
        }

        // hero's hp decreases depending on creature atk
        enemy.hp -= damageDealt;

        // output of enemy hero current hp and team
        // each attack decreases attacked creature quantity by one
        System.out.println("Enemy HP left: " + enemy.hp);
        System.out.println("Enemy units left:");

        for (Creature unit : enemy.getArmy().values()) {
            System.out.println(unit.name + ": " + unit.quantity);
        }
    }

    private boolean endBattle() {
        if (player1.getArmy().isEmpty() || player1.hp <= 0) {
            System.out.println(player2.name + " victory!");
            return true;
        } else if (player2.getArmy().isEmpty() || player2.hp <= 0) {
            System.out.println(player1.name + " victory!");
            return true;
        } else {
            return false;
        }
    }
}
