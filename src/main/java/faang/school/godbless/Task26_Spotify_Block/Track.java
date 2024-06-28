package faang.school.godbless.Task26_Spotify_Block;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Track {
    public String title;

    public Track(String title) {
        if (title.isBlank()) throw new IllegalArgumentException("the name is blank");
        else this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
