package school.faang.bjs249733;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(1);

        Player parvin = new Player("Parvin");
        Thread t1 = new Thread(() -> parvin.startBattle(boss, 5000));
        t1.start();

        Player narmin = new Player("Narmin");
        Thread t2 = new Thread(() -> narmin.startBattle(boss, 3000));
        t2.start();

        Player murad = new Player("Murad");
        Thread t3 = new Thread(() -> murad.startBattle(boss, 10000));
        t3.start();

        Player alex = new Player("Alex");
        Thread t4 = new Thread(() -> alex.startBattle(boss, 1000));
        t4.start();

    }
}
