package school.faang.bjs273515;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(1);
        Player player1 = new Player("Miras");
        Player player2 = new Player("Aruzhan");

        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        Thread thread2 = new Thread(() -> player2.doBattle(boss));

        thread1.start();
        thread2.start();
    }
}
