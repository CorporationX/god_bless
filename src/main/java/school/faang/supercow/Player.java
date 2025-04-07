package school.faang.supercow;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        boss.leaveBattle(this);
    }
}
