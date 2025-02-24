package school.faang.naughtwoBJS261662;


import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        checkName(name);
        this.name = name;
    }

    public synchronized void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
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
