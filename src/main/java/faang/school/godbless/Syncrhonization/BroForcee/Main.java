package faang.school.godbless.Syncrhonization.BroForcee;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            game.update();
            System.out.println("Score: " + game.getScore() + ", Lives: " + game.getLives());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}