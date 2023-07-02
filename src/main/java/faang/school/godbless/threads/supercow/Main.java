package faang.school.godbless.threads.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Vasya");
        Player player2 = new Player("Petya");
        Player player3 = new Player("Jeka");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));
    }
}
