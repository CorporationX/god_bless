package school.faang.naughtwoBJS261662;


import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private static final int SLEEP_TIME = 3000;

    public Player(String name) {
        checkName(name);
        this.name = name;
    }

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(SLEEP_TIME);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be 'null' or empty");
        }
    }
}
