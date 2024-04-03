package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Bernard");
        Player player2 = new Player("Lucy");
        Player player3 = new Player("John");
        Player player4 = new Player("Mark");

        player1.startBattle(boss);
        player2.startBattle(boss);
        player3.startBattle(boss);
        player4.startBattle(boss);
    }
}
