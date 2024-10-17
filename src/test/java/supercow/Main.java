package supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player1 = new Player("Vasya");
        Player player2 = new Player("Petya");
        Player player3 = new Player("Max");
        Player player4 = new Player("John");
        Player player5 = new Player("Olya");

        Thread thread1 = new Thread(()-> player1.startBattle(boss));
        Thread thread2 = new Thread(()-> player2.startBattle(boss));
        Thread thread3 = new Thread(()-> player3.startBattle(boss));
        Thread thread4 = new Thread(()-> player4.startBattle(boss));
        Thread thread5 = new Thread(()-> player5.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
