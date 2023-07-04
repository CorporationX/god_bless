package faang.school.godbless.Sprint_4.Multithreading_Synchronization.Supercow;

public class Arena {
    public static void main(String[] args) {
        Boss boss = new Boss(2, 0);
        Player p1 = new Player("p1", false);
        Player p2 = new Player("p2", false);
        Player p3 = new Player("p3", false);
        Player p4 = new Player("p4", false);

        Thread thread1 = new Thread(() -> {
            p1.startBattle(boss);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p1.endBattle(boss);
        });

        Thread thread2 = new Thread(() -> {
            p2.startBattle(boss);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p2.endBattle(boss);
        });

        Thread thread3 = new Thread(() -> {
            p3.startBattle(boss);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p3.endBattle(boss);
        });

        Thread thread4 = new Thread(() -> {
            p4.startBattle(boss);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p4.endBattle(boss);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
