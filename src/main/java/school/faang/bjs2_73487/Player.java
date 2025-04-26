package school.faang.bjs2_73487;

public class Player {
    public void doBattle(Boss boss) throws InterruptedException {
        System.out.println("Trying to join battle");
        boss.joinBattle();
        Thread.sleep(1000);
        boss.leaveBattle();
        System.out.println("Player left battle");
    }
}
