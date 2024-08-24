package faang.school.godbless.BJS2_24295;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        for (int i = 0; i < 10; i++) {
            Player player = new Player("Player" + i);
            Thread thread = new Thread(() -> player.startBattle(boss));
            thread.start();
        }
    }
}
