package faang.school.godbless.SuperCow;

public class Main {
    public static void main(String[] args) {
        startBattle(new Boss());
    }
    public static void startBattle(Boss boss) {
        boss.joinBattle(new Player("volodya"));
        boss.joinBattle(new Player("gena"));
        boss.joinBattle(new Player("beta"));
        boss.joinBattle(new Player("alpha"));
        boss.joinBattle(new Player("vsa"));
    }
}
