package faang.school.godbless.supercow;


public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void startBattle(Boss boss) {
        System.out.println(name + " wants to start the battle");
        try {
            boss.joinBattle(this);

            battle();

            boss.endBattle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void battle() throws InterruptedException {
        System.out.println(name + " is fighting");
        Thread.sleep(2000);
        System.out.println(name + " finished the battle");
    }
}
