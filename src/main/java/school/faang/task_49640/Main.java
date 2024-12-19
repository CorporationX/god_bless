package school.faang.task_49640;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);

        createPlayerAndStartBattle("dodge", boss);
        createPlayerAndStartBattle("fox", boss);
        createPlayerAndStartBattle("crig", boss);
        createPlayerAndStartBattle("kolin", boss);
        createPlayerAndStartBattle("sam", boss);
        createPlayerAndStartBattle("manshin", boss);
        createPlayerAndStartBattle("kris", boss);
        createPlayerAndStartBattle("abrakadabra", boss);
    }

    private static void createPlayerAndStartBattle(String playerName, Boss boss) {
        new Player(playerName).startBattle(boss);
    }
}
