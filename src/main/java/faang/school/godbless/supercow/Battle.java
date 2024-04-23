package faang.school.godbless.supercow;

public class Battle {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player tom = new Player("Tom");
        Player bob = new Player("Bob");
        Player ann = new Player("Ann");
        Player david = new Player("David");
        Thread tomThread = new Thread(() -> tom.startBattle(boss));
        Thread bobThread = new Thread(() -> bob.startBattle(boss));
        Thread annThread = new Thread(() -> ann.startBattle(boss));
        Thread davidThread = new Thread(() -> david.startBattle(boss));
        tomThread.start();
        bobThread.start();
        annThread.start();
        davidThread.start();
        try {
            tomThread.join();
            bobThread.join();
            annThread.join();
            davidThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Сражение завершено");
    }
}

