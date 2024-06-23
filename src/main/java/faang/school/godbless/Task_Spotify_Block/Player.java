package faang.school.godbless.Task_Spotify_Block;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private enum status {
        playing, pause
    }

    private status isPlaying;

    private static final List<Track> TRACK_LIST = new ArrayList<>();

    public void play(Track track) {
        if (!TRACK_LIST.contains(track)) System.out.println("The track is not in the playlist");
        else System.out.println("Track " + track.getTitle() + " is now playing");
    }

    public void pause() {

    }

    public void skin() {

    }

    public void previous() {

    }

    static {
        TRACK_LIST.add(new Track("Stick Stickly"));
        TRACK_LIST.add(new Track("Take One Last Breath"));
        TRACK_LIST.add(new Track("Prophecy"));
    }


}
