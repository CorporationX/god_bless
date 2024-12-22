package school.faang.sprint_1.task_supercowbjs2n49687;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

}
