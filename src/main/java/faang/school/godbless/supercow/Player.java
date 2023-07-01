package faang.school.godbless.supercow;

public class Player {
    private String name;

    public void startBattle(Boss boss){
        boss.joinBattle(this);
    }
}
