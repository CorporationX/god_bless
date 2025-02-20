package school.faang.supercow.BJS2_61566;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player frieren = new Player("Frieren");
        Player fern = new Player("Fern");
        Player stark = new Player("Stark");

        Thread thread1 = new Thread(() -> frieren.doBattle(boss));
        Thread thread2 = new Thread(() -> fern.doBattle(boss));
        Thread thread3 = new Thread(() -> stark.doBattle(boss));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
