package school.faang.supercow;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player jon = new Player("Jon");
        Player ben = new Player("ben");
        Player stiv = new Player("stiv");
        Player sam = new Player("sam");
        Player bob = new Player("sam");
        Player pick = new Player("sam");
        Player bib = new Player("sam");

        Thread thread1 = new Thread(() -> jon.doBattle(boss));
        Thread thread2 = new Thread(() -> ben.doBattle(boss));
        Thread thread3 = new Thread(() -> stiv.doBattle(boss));
        Thread thread4 = new Thread(() -> sam.doBattle(boss));
        Thread thread5 = new Thread(() -> bob.doBattle(boss));
        Thread thread6 = new Thread(() -> pick.doBattle(boss));
        Thread thread7 = new Thread(() -> bib.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

    }
}
