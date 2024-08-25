package BJS2_24139_Supercow;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
