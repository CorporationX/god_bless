package faang.school.godbless.BJS2_24190;

public class Fight {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player1 = new Player("Elon");
        Player player2 = new Player("Max");
        Player player3 = new Player("Andrey");
        Player player4 = new Player("Robert");
        Player player5 = new Player("Amirhan");

        Thread threadPlayer1 = new Thread(() -> player1.startBattle(boss));
        Thread threadPlayer2 = new Thread(() -> player2.startBattle(boss));
        Thread threadPlayer3 = new Thread(() -> player3.startBattle(boss));
        Thread threadPlayer4 = new Thread(() -> player4.startBattle(boss));
        Thread threadPlayer5 = new Thread(() -> player5.startBattle(boss));

        threadPlayer1.start();
        threadPlayer2.start();
        threadPlayer3.start();
        threadPlayer4.start();
        threadPlayer5.start();

    }
}
