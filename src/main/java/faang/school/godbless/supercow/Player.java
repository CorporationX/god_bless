package faang.school.godbless.supercow;

public class Player extends Thread {
    private final String playerName;
    private final Boss boss;

    public Player(String playerName, Boss boss) {
        this.playerName = playerName;
        this.boss = boss;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep((int) (Math.random() * 3000));
            boss.endBattle(this);
        } catch (InterruptedException e) {
            System.out.println("The game is interrupted");
        }
    }

    @Override
    public void run(){
        startBattle(boss);
    }
}
