package supercow;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boss.finishBattle();
    }
}
