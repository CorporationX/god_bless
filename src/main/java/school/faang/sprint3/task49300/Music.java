package school.faang.sprint3.task49300;

import java.util.Random;

public class Music {
    private static final int MAX_THREADS = 10;
    private static final int MAX_PLAYER_OPERATIONS = 4;

    public static void main(String[] args) {
        Player player = new Player();
        for (int i = 0; i < MAX_THREADS; i++) {
            Random random = new Random();
            int nextOperationCode = random.nextInt(MAX_PLAYER_OPERATIONS);
            userOperation(player, getOperationByCode(nextOperationCode));
        }
    }

    private static PlayerOperation getOperationByCode(int operationCode) {
        return switch (operationCode) {
          case 0 -> PlayerOperation.PLAY;
          case 1 -> PlayerOperation.PAUSE;
          case 2 -> PlayerOperation.SKIP;
          case 3 -> PlayerOperation.PREVIOUS;
          default -> throw new IllegalArgumentException("Некорректный код операции!");
        };
    }

    private static void userOperation(Player player, PlayerOperation operation) {
        Thread thread;
        switch (operation) {
          case PLAY -> thread = new Thread(player::play);
          case PAUSE -> thread = new Thread(player::pause);
          case SKIP -> thread = new Thread(player::skip);
          case PREVIOUS -> thread = new Thread(player::previous);
          default -> throw new IllegalArgumentException("Некорректная операция над плеером!");
        }
        thread.start();
    }
}
