package youtube;

import lombok.Data;

@Data
public class Video {
    private int videoID;
    private String name;
    private int views;
    private static int counterID = 1;

    public Video(String name) {
        this.videoID = counterID;
        this.name = name;
        this.views = 0;
        counterID++;
    }
}
