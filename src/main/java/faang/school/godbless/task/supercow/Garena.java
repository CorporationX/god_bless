package faang.school.godbless.task.supercow;

public class Garena {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player mask = new Player("Elon Mask");
        Player mark = new Player("Mark Zuckerberg");
        Player mike = new Player("Mike Tyson");

        Thread maskThread = new Thread(() -> mask.startBattle(boss));
        Thread markThread = new Thread(() -> mark.startBattle(boss));
        Thread mikeThread = new Thread(() -> mike.startBattle(boss));

        maskThread.start();
        markThread.start();
        mikeThread.start();
    }
}
