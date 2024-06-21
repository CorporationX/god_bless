package faang.school.godbless.multithreading.youtube;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Video {
    private String videoName;
    private int videoId;
    private static int idBuffer;

    public Video(String videoName) {
        this.videoName = videoName;
        idBuffer++;
        this.videoId = idBuffer;
    }

    public static List<Video> addVideoToList(int numVideos) {
        List<Video> videos = new ArrayList<>();
        for (int i = 0; i < numVideos; i++) {
            videos.add(new Video("video" + i));
        }
        return videos;
    }
}
