package faang.school.godbless.supercow;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " started the battle");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boss.finishBattle();
        System.out.println(name + " finished the battle");
    }
}
