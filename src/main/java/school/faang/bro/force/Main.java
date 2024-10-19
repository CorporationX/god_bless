package school.faang.bro.force;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(3);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> game.update(new Update(true, false)));
            thread.start();
        }
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> game.update(new Update(true, true)));
            thread.start();
        }
    }
}
