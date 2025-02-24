package school.faang.BJS2_63887;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class User implements Runnable {
    private final String name;
    private final Player player;
    private static final int MIN_ACTION = 1;
    private static final int MAX_ACTION = 4;

    private void play() {
        synchronized (player.getLock()) {
            System.out.printf("%nПользователь %s воспроизводит музыку%n", name);
            player.play();
        }
    }

    private void pause() {
        synchronized (player.getLock()) {
            System.out.printf("%nПользователь %s ставит на паузу музыку%n", name);
            player.pause();
        }
    }

    private void playAndPause() {
        synchronized (player.getLock()) {
            if (player.isPlaying()) {
                pause();
            } else {
                play();
            }
        }
    }

    private void skip() {
        synchronized (player.getLock()) {
            System.out.printf("%nПользователь %s переходит к следующему треку%n", name);
            player.skip();
        }
    }

    private void previous() {
        synchronized (player.getLock()) {
            System.out.printf("%nПользователь %s возвращается к предыдущему треку%n", name);
            player.previous();
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        int actionNumber = random.nextInt(MIN_ACTION, MAX_ACTION);

        switch (actionNumber) {
            case 1 -> playAndPause();
            case 2 -> skip();
            case 3 -> previous();
            default -> System.out.println("Неизвестное действие: " + actionNumber);
        }
    }
}
