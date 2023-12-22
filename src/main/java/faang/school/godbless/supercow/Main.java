package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player_1 = new Player("Bob");
        Player player_2 = new Player("Tom");
        Player player_3 = new Player("Iren");

        Thread thread_1 = new Thread(() -> player_1.startBattle(boss));
        Thread thread_2 = new Thread(() -> player_2.startBattle(boss));
        Thread thread_3 = new Thread(() -> player_3.startBattle(boss));
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}
