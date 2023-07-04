package Multithreading.bc2868;

public record Player(String name) {
    public void startBattle(Boss boss) throws InterruptedException {

            boss.joinBattle(this);
            System.out.println(name() + " start battle with Boss");
            boss.endBattle(this);
        }

}
