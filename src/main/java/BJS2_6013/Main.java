package BJS2_6013;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player monk = new Player("Монклерк");
        Player hunter = new Player("Монтрапа");
        Player warlock = new Player("Монболт");

        Thread thread = new Thread(() -> monk.startBattle(boss));
        Thread thread1 = new Thread(() -> hunter.startBattle(boss));
        Thread thread2 = new Thread(() -> warlock.startBattle(boss));


        thread.start();
        thread1.start();
        thread2.start();
    }
}
