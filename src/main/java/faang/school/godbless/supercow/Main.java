package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        new Thread(() -> new Player("1й").startBattle(boss)).start();
        new Thread(() -> new Player("2й").startBattle(boss)).start();
        new Thread(() -> new Player("3й").startBattle(boss)).start();
        new Thread(() -> new Player("4й").startBattle(boss)).start();
        new Thread(() -> new Player("5й").startBattle(boss)).start();
        new Thread(() -> new Player("6й").startBattle(boss)).start();
        new Thread(() -> new Player("7й").startBattle(boss)).start();
        new Thread(() -> new Player("8й").startBattle(boss)).start();
        new Thread(() -> new Player("9й").startBattle(boss)).start();
        new Thread(() -> new Player("10й").startBattle(boss)).start();

    }
}
