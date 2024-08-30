package threadwto.four;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 5);

        for (int i = 0; i < 7; i++) {
            game.update();
        }
    }
}
