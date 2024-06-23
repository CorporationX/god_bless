package faang.school.godbless.Task_Spotify_Block;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private enum Status {
        playing, pause
    }

    private int currentTrack;
    private Status isPlaying;

    static final List<Track> TRACK_LIST = new ArrayList<>();

    public Player() {
        this.isPlaying = Status.pause;
        this.currentTrack = 0;
    }

    public Player(int currentTrack, Status status) {
        if (currentTrack >= TRACK_LIST.size()) throw new IllegalArgumentException("index is out of range");
        this.currentTrack = currentTrack;
        this.isPlaying = status;
    }

    public synchronized void play(Track track) {
            if (!TRACK_LIST.contains(track)) System.out.println("The track is not in the playlist");
            else {
                this.isPlaying = Status.playing;
                currentTrack = TRACK_LIST.indexOf(track);
                System.out.println(track + " is now playing");
            }
    }

    public synchronized void pause() {
        this.isPlaying = Status.pause;
        System.out.println(TRACK_LIST.get(currentTrack) + " is paused");
    }

    public synchronized void skip() {
        if (currentTrack == TRACK_LIST.size() - 1) {
            currentTrack = 0;
            isPlaying = Status.playing;
            System.out.println(TRACK_LIST.get(0) + " is now playing");
        } else {
            currentTrack = currentTrack + 1;
            System.out.println("The next track " + TRACK_LIST.get(currentTrack) + " is now playing");
        }
        isPlaying = Status.playing;
    }

    public synchronized void previous() {
        if (currentTrack == 0) {
            currentTrack = TRACK_LIST.size() - 1;
            System.out.println(TRACK_LIST.get(currentTrack) + " is now playing");
        } else {
            currentTrack = currentTrack - 1;
            System.out.println(TRACK_LIST.get(currentTrack) + " is now playing");
        }
        isPlaying = Status.playing;
    }

    public synchronized static void addTrack(Track track) {
        synchronized (TRACK_LIST) {
                TRACK_LIST.add(track);
                System.out.println("The playlist was updated");
                System.out.println(TRACK_LIST);
        }
    }

    static {
        TRACK_LIST.add(new Track("Stick Stickly"));
        TRACK_LIST.add(new Track("Take One Last Breath"));
        TRACK_LIST.add(new Track("Prophecy"));
    }

}
