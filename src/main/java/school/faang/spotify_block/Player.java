package school.faang.spotify_block;

import ch.qos.logback.classic.spi.EventArgUtil;

public class Player {

    Object lock = new Object();

    int songPlayingNow = Music.songPlayingNow;
    String[] musics = Music.musics;
    int musicsLength = musics.length;

    private static boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music is playing: " + musics[songPlayingNow]);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (songPlayingNow == musicsLength - 1) {
                songPlayingNow = 0;
            } else {
                songPlayingNow++;
            }
            System.out.println("Music is playing: " + musics[songPlayingNow]);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (songPlayingNow == 0) {
                songPlayingNow = musicsLength - 1;
            } else {
                songPlayingNow--;
            }
            System.out.println("Music is playing: " + musics[songPlayingNow]);
        }
    }
}
