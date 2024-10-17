package school.faang.broforce;

public class Main {
    public static void main(String[] args) {
        Player nagibator = new Player("Nagibator");
        Player killer = new Player("Killer");
        Player fallenangel = new Player("FallenAngel");

        Game game = new Game();

        Thread one = new Thread(() -> {
            while (Game.isGameIsOn()) {
                nagibator.hitPlayer(killer, game);
                game.update(nagibator);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread two = new Thread(() -> {
            while (Game.isGameIsOn()) {
                killer.hitPlayer(fallenangel, game);
                game.update(killer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread three = new Thread(() -> {
            while (Game.isGameIsOn()) {
                fallenangel.hitPlayer(nagibator, game);
                game.update(fallenangel);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        one.start();
        two.start();
        three.start();
    }
}
