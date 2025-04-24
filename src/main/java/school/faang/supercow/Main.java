package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Паук Бил");
        Player player2 = new Player("Скорпион Чак");
        Player player3 = new Player("Анаконда Трис");
        Player player4 = new Player("Малыш Джо");

        final Thread thread1 = new Thread(() -> player1.doBattle(boss));
        final Thread thread2 = new Thread(() -> player2.doBattle(boss));
        final Thread thread3 = new Thread(() -> player3.doBattle(boss));
        final Thread thread4 = new Thread(() -> player4.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
