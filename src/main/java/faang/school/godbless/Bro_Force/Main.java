package faang.school.godbless.Bro_Force;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game();
        Thread thread = new Thread(() -> newGame.update());
        thread.start();
    }
}
