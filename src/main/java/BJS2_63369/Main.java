package BJS2_63369;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Player charlie = new Player("Charlie");

        new Thread(() -> alice.doBattle(boss)).start();
        new Thread(() -> bob.doBattle(boss)).start();
        new Thread(() -> charlie.doBattle(boss)).start();
    }
}
