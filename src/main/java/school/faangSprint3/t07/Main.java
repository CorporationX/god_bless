package school.faangSprint3.t07;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1", boss);
        Player player2 = new Player("Игрок 2", boss);
        Player player3 = new Player("Игрок 3", boss);
        Player player4 = new Player("Игрок 4", boss);

        player1.startBattle();
        player2.startBattle();
        player3.startBattle();
        player4.startBattle();
    }
}