package school.faang.BJS2_37014;

public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    public Player(String name, Boss boss) {
        this.name = name;
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void startBattle() {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            e.printStackTrace();
        } finally {
            boss.leaveBattle(this);
        }
    }

    @Override
    public void run() {
        startBattle();
    }
}
