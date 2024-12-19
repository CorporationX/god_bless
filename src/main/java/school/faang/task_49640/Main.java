package school.faang.task_49640;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);
        
        Player player = new Player("player 1");
        Player player2 = new Player("player 2");
        Player player3 = new Player("player 3");
        Player player4 = new Player("player 4");
        Player player5 = new Player("player 5");
        Player player6 = new Player("player 6");
        Player player7 = new Player("player 7");

        player.startBattle(boss);
        player2.startBattle(boss);
        player3.startBattle(boss);
        player4.startBattle(boss);
        player5.startBattle(boss);
        player6.startBattle(boss);
        player7.startBattle(boss);
    }
}
