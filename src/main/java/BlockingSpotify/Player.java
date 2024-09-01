package BlockingSpotify;

import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean isPlaying = false;

    public void play() {
        lock.lock(); // Получение блокировки
        try {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка сейчас играет.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        } finally {
            lock.unlock(); // Снимаем блокировку
        }
    }

    public void pause() {
        lock.lock(); // Получение блокировки
        try {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу");
            } else {
                System.out.println("Музыка уже поставлена на паузу");
            }
        } finally {
            lock.unlock(); // Снимаем блокировку
        }
    }

    public void skip() {
        lock.lock(); // Получение блокировки
        try {
            if (isPlaying) {
                System.out.println("Переходим к следующему треку");
// Логика перехода к следующему треку может быть добавлена сюда
            } else {
                System.out.println("Не могу пропустить, музыка поставлена на паузу");
            }
        } finally {
            lock.unlock(); // Снимаем блокировку
        }
    }

    public void previous() {
        lock.lock(); // Получение блокировки
        try {
            if (isPlaying) {
                System.out.println("Возвращаемся к предыдущему треку");
// Логика перехода к предыдущему треку может быть добавлена сюда
            } else {
                System.out.println("Не могу вернуться назад, музыка поставлена на паузу");
            }
        } finally {
            lock.unlock(); // Снимаем блокировку
        }
    }
}
