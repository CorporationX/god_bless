package faang.school.godbless.Supercow;

public class Battles {
    public static void main(String[] args) {
        Boss bigBoss = new Boss(10, 3);
        Thread thread1 = new Thread(() -> bigBoss.joinBattle(new Player("Bobo")));
        Thread thread2 = new Thread(() -> bigBoss.joinBattle(new Player("Bibi")));
        Thread thread3 = new Thread(() -> {
            bigBoss.joinBattle(new Player("Bubu"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bigBoss.leaveBattle(new Player("Bubu"));
        });
        Thread thread4 = new Thread(() -> bigBoss.joinBattle(new Player("Bebe")));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("А усё");
    }
}
