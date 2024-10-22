package school.faang_sprint_3.bro_force;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        var random = new Random();
        var game = new Game();

        for (var i = 0; i < 20; i++) {
            game.update(random.nextBoolean(), random.nextBoolean());
        }
    }
}
