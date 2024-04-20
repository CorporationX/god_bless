package broForce;

public class Main {
    private static final int NUMBER_OF_PLAYERS = 4;

    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("Nick");
        Player player2 = new Player("Paul");
        Player player3 = new Player("Vadim");
        Player player4 = new Player("Anya");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);

        for (int i = 0; i <= NUMBER_OF_PLAYERS; i++) {
            Thread thread = new Thread(game::update);
            thread.start();
        }
    }
}
