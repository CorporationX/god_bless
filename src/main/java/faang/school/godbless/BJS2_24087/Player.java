package faang.school.godbless.BJS2_24087;

public record Player(String name) {

    public void startBattle(Boss boss){
        boss.joinBattle(this);
    }
}
