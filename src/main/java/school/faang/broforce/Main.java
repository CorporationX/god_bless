package school.faang.broforce;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bro broden = new Bro("Broden", 20);
        Bro brodator = new Bro("Brodator", 20);
        Game game = new Game(List.of(broden, brodator));
        game.start();
    }
}
