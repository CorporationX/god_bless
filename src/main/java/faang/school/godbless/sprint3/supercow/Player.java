package faang.school.godbless.sprint3.supercow;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinPlayer(this);
        boss.endBattle(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
