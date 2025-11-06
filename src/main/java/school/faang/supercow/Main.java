package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        boss.setCurrentPlayers(0);
        Player player1 = new Player("гнат");
        Player player2 = new Player("Женя");
        Player player3 = new Player("Вова");

        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        Thread thread2 = new Thread(() -> player2.doBattle(boss));
        Thread thread3 = new Thread(() -> player3.doBattle(boss));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
