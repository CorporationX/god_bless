package school.faang.bjs2_92225;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");

        Thread th1 = new Thread(() -> player1.doBattle(boss));
        Thread th2 = new Thread(() -> player2.doBattle(boss));
        Thread th3 = new Thread(() -> player3.doBattle(boss));
        Thread th4 = new Thread(() -> player4.doBattle(boss));

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
