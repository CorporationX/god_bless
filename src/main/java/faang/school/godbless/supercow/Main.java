package faang.school.godbless.supercow;

public class Main {
    public static void main(String... args) {
        Boss firstBoss = new Boss("Вурдалак", 3);
        Player firstPlayer = new Player("Alex");
        Player secondPlayer = new Player("Micky");
        Player thirdPlayer = new Player("Миша");
        Player fourthPlayer = new Player("Дима");

        Thread secondThread = new Thread(new Battle(firstBoss, firstPlayer));
        Thread firstThread = new Thread(new Battle(firstBoss, secondPlayer));
        Thread thirdThread = new Thread(new Battle(firstBoss, thirdPlayer));
        Thread forthThread = new Thread(new Battle(firstBoss, fourthPlayer));
        secondThread.start();
        firstThread.start();
        thirdThread.start();
        forthThread.start();
    }
}