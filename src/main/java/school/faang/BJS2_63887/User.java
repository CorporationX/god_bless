package school.faang.BJS2_63887;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class User implements Runnable {
    private final String name;
    private final Player player;

    private static final int MIN_ACTION = 1;
    private static final int MAX_ACTION = 4;


    private void play() {
        Lock lock = (Lock) player.getLock();
        lock.lock();
        try {
            System.out.printf("%nПользователь %s воспроизводит музыку%n", name);
            player.play();
        } finally {
            lock.unlock();
        }

    }

    private void pause() {
        Lock lock = (Lock) player.getLock();
        lock.lock();
        try {
            System.out.printf("%nПользователь %s ставит на паузу музыку%n", name);
            player.pause();
        } finally {
            lock.unlock();
        }
    }

    private void playAndPause() {
        Lock lock = (Lock) player.getLock();
        lock.lock();
        try {
            if (player.isPlaying()) {
                pause();
            } else {
                play();
            }
        } finally {
            lock.unlock();
        }
    }

    private void skip() {
        Lock lock = (Lock) player.getLock();
        lock.lock();
        try {
            System.out.printf("%nПользователь %s переходит к следующему треку%n", name);
            player.skip();
        } finally {
            lock.unlock();
        }
    }

    private void previous() {
        Lock lock = (Lock) player.getLock();
        lock.lock();
        try {
            System.out.printf("%nПользователь %s возвращается к предыдущему треку%n", name);
            player.previous();
        } finally {
            lock.unlock();
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
