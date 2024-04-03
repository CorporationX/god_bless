package broForce;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Random randomLives = new Random();

        Bro bro1 = new Bro("James", randomLives.nextInt(1, 11));
        Bro bro2 = new Bro("Gregory", randomLives.nextInt(1,11));

        game.addBro(bro1);
        game.addBro(bro2);

        Thread joinThread = new Thread(() -> {
            try {
                    while(true) {
                        game.update();
                        Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        joinThread.start();
    }
}
