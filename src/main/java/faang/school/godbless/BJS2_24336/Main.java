package faang.school.godbless.BJS2_24336;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2, 0);
        Player max = new Player("Max");
        Player olga = new Player("Olga");
        Player vlad = new Player("Vlad");
        Thread maxFightThread = new Thread(() -> max.startBattle(boss));
        Thread olgaFightThread = new Thread(() -> olga.startBattle(boss));
        Thread vladFightThread = new Thread(() -> vlad.startBattle(boss));
        maxFightThread.start();
        olgaFightThread.start();
        vladFightThread.start();
    }
}
