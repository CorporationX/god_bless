package YouTube;

import lombok.Getter;

@Getter
public class Video {
    private static int index = 0;
    private final int videoId;

    public Video() {
        this.videoId = index;
        index++;
    }
}
