package faang.school.godbless.multithreading.spotify;

import java.util.List;

public class Music {

    public static void main(String[] args) throws InterruptedException {

        Player player = new Player();
        List<String> playList = List.of("Было круто", "Белая ночь", "Спектакль окончен", "I'm Just Ken", "Remember When");

        Thread addMusic = new Thread(() -> player.addMusic("Sid & Nancy"));

        Thread addListMusic = new Thread(() -> player.addMusic(playList));

        Thread playThread = new Thread(player::play);

        Thread pauseThread = new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread skipThread = new Thread(player::pause);

        Thread previousThread = new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        addMusic.start();
        addListMusic.start();
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
