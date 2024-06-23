package faang.school.godbless.Task_Spotify_Block;

import lombok.Getter;

@Getter
public class Track {

    public String title;
    public int length;

    public Track(String title) {
        if (title.isBlank()) throw new IllegalArgumentException("the name is blank");
        else this. title = title;
    }

    public void setLength(int seconds) {
        if (seconds == 0) throw new IllegalArgumentException("zero time");
        else this.length = seconds;
    }

    @Override
    public String toString() {
        return title;
    }

}
