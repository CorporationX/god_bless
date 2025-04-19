package school.faang.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Character player = new Warrior("dextomi");
        Character opponent = new Archer("iseka");

        var characterTurn = CharacterConfig.Turn.PLAYER_TURN;

        while (player.getCurrentHealth() > 0 && opponent.getCurrentHealth() > 0) {
            switch (characterTurn) {
                case PLAYER_TURN:
                    playerAttack(player, opponent);
                    break;
                case OPPONENT_TURN:
                    opponentAttack(player, opponent);
                    break;
                default:
                    break;
            }
            announceWinner(player, opponent);
        }
    }

    public static void playerAttack(Character player, Character opponent) {
        player.attack(opponent);
        System.out.printf("dextomi did %d damage, iseka's current health is %d\n",
                player.getStrength(), opponent.getCurrentHealth());
    }

    public static void opponentAttack(Character player, Character opponent) {
        opponent.attack(player);
        System.out.printf("iseka did %d damage, dextomi's current health is %d\n",
                opponent.getAgility(), player.getCurrentHealth());
    }

    public static void announceWinner(Character player, Character opponent) {
        if (player.getCurrentHealth() == 0) {
            System.out.println("iseka wins!");
        }
        if (opponent.getCurrentHealth() == 0) {
            System.out.println("dextomi wins!");
        }
    }
}