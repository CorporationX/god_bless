package supercow;

public class Main {
    public static int MAX_PLAYERS = 10;
    public static void main(String[] args) {
        Boss boss = new Boss(new Object(), MAX_PLAYERS);
        for (int i = 0; i < MAX_PLAYERS * 2; i++) {
            new Player("Player" + i).startBattle(boss);
        }
    }
}
