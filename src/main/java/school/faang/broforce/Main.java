package school.faang.broforce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(5); // 5 жизней на всю игру

        Thread p1 = new Thread(new Player(game, "Alice", 1));
        Thread p2 = new Thread(new Player(game, "Bob", 2));
        Thread p3 = new Thread(new Player(game, "Charlie", 1));

        p1.start();
        p2.start();
        p3.start();
    }
}