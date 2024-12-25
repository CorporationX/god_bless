package school.faang.spotifyblocking;

import lombok.Setter;

@Setter
public class Player {
    private boolean isPlaying = false;

    public synchronized void play() {
        if (!isPlaying) {
            System.out.println("The music is playing");
            setPlaying(true);
        } else {
            System.out.println("The music is already playing");
        }
    }

    public synchronized void pause() {
        if (isPlaying) {
            System.out.println("The music is paused");
            setPlaying(false);
        } else {
            System.out.println("The music is already on pause");
        }
    }

    public synchronized void skip() {
        System.out.println("Track was skipped");
    }

    public synchronized void previous() {
        System.out.println("Returned to the previous track");

    }
}
