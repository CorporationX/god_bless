package faang.school.godbless.multi.task1force;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Player player1 = new Player(game, "Игрок 1", 4);
        Player player2 = new Player(game, "Игрок 2", 4);
        Player player3 = new Player(game, "Игрок 3", 3);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        new Thread(player1).start();
        new Thread(player2).start();
        new Thread(player3).start();

        new Thread(player1).join();
        new Thread(player2).join();
        new Thread(player3).join();
    }
}
