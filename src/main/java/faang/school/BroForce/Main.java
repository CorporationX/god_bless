package faang.school.BroForce;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(game::update);
            thread.start();
            thread.join();
        }
        System.out.println("Done");
    }
}
