package school.faang.supercow;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player jon = new Player("Jon");
        Player ben = new Player("ben");
        Player stiv = new Player("stiv");

        Thread thread1 = new Thread(() -> jon.doBattle(boss));
        Thread thread2 = new Thread(() -> ben.doBattle(boss));
        Thread thread3 = new Thread(() -> stiv.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
