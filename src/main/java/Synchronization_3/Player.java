package Synchronization_3;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public String getName() {
        return name;
    }
}
