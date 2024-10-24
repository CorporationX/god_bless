package MultithreadingSupercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player p1 = new Player("Dilnura");
        Player p2 = new Player("Zarina");
        Player p3 = new Player("Dilafruz");
        Player p4 = new Player("Abror");
        Player p5 = new Player("Babina");

        Thread playerThread = new Thread(() -> {
            try {
                p1.startBattle(boss);
                Thread.sleep(5000);
                p2.startBattle(boss);
                Thread.sleep(5000);
                boss.leaveBattle(p2);
                p3.startBattle(boss);
                Thread.sleep(5000);
                boss.leaveBattle(p1);
                p4.startBattle(boss);
                p5.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
        });

        playerThread.start();
    }
}
