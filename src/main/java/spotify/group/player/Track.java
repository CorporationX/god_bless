package spotify.group.player;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Track {
    private final String artist;
    private final String title;

    public Track(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }
}
