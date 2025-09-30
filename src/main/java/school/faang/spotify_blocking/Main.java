package school.faang.spotify_blocking;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {
    public static void main(String[] args) {
        Object lock = new Object(); //объект блокировки
        Player player = new Player(lock);
        Music music = new Music(player);

        music.startSessions(); //запускаем потоки
    }
}