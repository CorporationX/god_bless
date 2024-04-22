package faang.school.godbless.module.third.synchronization.supercow;

public class Main {
    private static int COUNTER = 0;
    
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> startBattle(boss)).start();
            ++COUNTER;
        }
    }
    
    public static void startBattle(Boss boss) {
        Player player = new Player("Игрок " + COUNTER);
        boss.joinBattle(player);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(player);
    }
}
