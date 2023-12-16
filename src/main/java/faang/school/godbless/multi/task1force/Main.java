package faang.school.godbless.multi.task1force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 3);

        for (int i = 0; i < 7; i++) {
            game.update1();
        }
    }
}
