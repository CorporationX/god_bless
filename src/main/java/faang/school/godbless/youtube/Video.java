package faang.school.godbless.youtube;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Video {
    private static int currentId = 0;//id последнего созданного видео
    private int id;
    private String title;

    public Video(String title) {
        this.title = title;
        id = ++currentId;
    }
}
