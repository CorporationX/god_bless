package school.faang.bjs2_36902;

public class Player implements Runnable {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    @Override
    public void run() {

        Boss boss = BossManager.getBossInstance();
        startBattle(boss);
    }
}
