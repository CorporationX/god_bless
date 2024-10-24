package spotify.group.player;

import java.util.Arrays;
import java.util.List;

public class Music {

    public static void main(String[] args) {
        List<Track> playlist = Arrays.asList(
                new Track("Земфира", "Прогулка"),
                new Track("Сплин", "Урок географии"),
                new Track("Мумий Тролль", "Медведица"),
                new Track("Алиса", "Трасса Е-95"),
                new Track("Эдуард Хиль", "Я очень рад, ведь я наконец возвращаюсь домой")
        );

        Player player = new Player(playlist);

        Thread alice = new Thread(() -> {
            player.play();
        }, "Алиса");

        Thread jabberWock = new Thread(() -> {
            player.pause();
        }, "Бормоглот");

        Thread whiteRabbit = new Thread(player::next, "Белый кролик");

        Thread madHatter = new Thread(player::play, "Безумный шляпник");

        Thread queenOfHearts = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                player.previous();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток Королевы сердец был прерван");
                }
            }
        }, "Королева Сердец");

        alice.start();
        jabberWock.start();
        whiteRabbit.start();
        madHatter.start();
        queenOfHearts.start();
    }
}
