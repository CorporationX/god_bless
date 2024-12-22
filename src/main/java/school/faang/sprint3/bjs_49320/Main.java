package school.faang.sprint3.bjs_49320;

public class Main {
    public static void main(String[] args) {
        boolean isScorePointGot;
        boolean isLivePointLost;
        Game game = new Game();

        while (game.getLives() > 0) {
            isScorePointGot = getRandomValue();
            isLivePointLost = getRandomValue();
            game.update(isScorePointGot, isLivePointLost);
            sleepThread();
        }
    }

    private static boolean getRandomValue() {
        return Math.random() < 0.5;
    }

    private static void sleepThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }
}
