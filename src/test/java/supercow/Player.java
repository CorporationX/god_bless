package supercow;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("The battle is not over");
        }
        boss.leaveBattle(this);
    }
}
