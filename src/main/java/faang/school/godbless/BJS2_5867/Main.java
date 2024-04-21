package faang.school.godbless.BJS2_5867;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player("Batman", true, 0, 0);
        Player player2 = new Player("Robin", true, 0, 0);
        Player player3 = new Player("Aqua-man", true, 0, 0);
        Player player4 = new Player("Spider-man", true, 0, 0);
        Player player5 = new Player("Witcher", true, 0, 0);
        Player player6 = new Player("Tanos", true, 0, 0);
        Player player7 = new Player("Terminator", true, 0, 0);
        Player player8 = new Player("Robocop", true, 0, 0);
        Player player9 = new Player("Rambo", true, 0, 0);

        game.addNewPlayersInGame(player1);
        game.addNewPlayersInGame(player2);
        game.addNewPlayersInGame(player3);
        game.addNewPlayersInGame(player4);
        game.addNewPlayersInGame(player5);
        game.addNewPlayersInGame(player6);
        game.addNewPlayersInGame(player7);
        game.addNewPlayersInGame(player8);
        game.addNewPlayersInGame(player9);

        Thread gameUpdate = new Thread(game::update);
        Thread player1ThreadScore = new Thread(player1::earnScore);
        Thread player2ThreadScore = new Thread(player2::earnScore);
        Thread player3ThreadScore = new Thread(player3::earnScore);
        Thread player4ThreadScore = new Thread(player4::earnScore);
        Thread player5ThreadScore = new Thread(player5::earnScore);
        Thread player6ThreadScore = new Thread(player6::earnScore);
        Thread player7ThreadScore = new Thread(player7::earnScore);
        Thread player8ThreadScore = new Thread(player8::earnScore);
        Thread player9ThreadScore = new Thread(player9::earnScore);
        Thread player1ThreadKill = new Thread(player1::killPlayer);
        Thread player2ThreadKill = new Thread(player2::killPlayer);
        Thread player3ThreadKill = new Thread(player3::killPlayer);
        Thread player4ThreadKill = new Thread(player4::killPlayer);
        Thread player5ThreadKill = new Thread(player5::killPlayer);
        Thread player6ThreadKill = new Thread(player6::killPlayer);
        Thread player7ThreadKill = new Thread(player7::killPlayer);
        Thread player8ThreadKill = new Thread(player8::killPlayer);
        Thread player9ThreadKill = new Thread(player9::killPlayer);
        gameUpdate.start();

        player1ThreadScore.start();
        player2ThreadScore.start();
        player3ThreadScore.start();
        player4ThreadScore.start();
        player5ThreadScore.start();
        player6ThreadScore.start();
        player7ThreadScore.start();
        player8ThreadScore.start();
        player9ThreadScore.start();
        player1ThreadKill.start();
        player2ThreadKill.start();
        player3ThreadKill.start();
        player4ThreadKill.start();
        player5ThreadKill.start();
        player6ThreadKill.start();
        player7ThreadKill.start();
        player8ThreadKill.start();
        player9ThreadKill.start();
    }
}
