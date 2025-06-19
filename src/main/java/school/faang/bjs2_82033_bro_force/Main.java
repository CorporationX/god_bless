package school.faang.bjs2_82033_bro_force;

public class Main {
    public static void main(String[] args) {
        Game myGame = new Game(10);

        new Thread(new Player("P1", myGame)).start();
        new Thread(new Player("P2", myGame)).start();
        new Thread(new Player("P3", myGame)).start();
        new Thread(new Player("P4", myGame)).start();
    }
}
