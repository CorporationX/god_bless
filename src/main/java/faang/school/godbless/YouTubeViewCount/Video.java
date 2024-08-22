package faang.school.godbless.YouTubeViewCount;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Video {
    @EqualsAndHashCode.Exclude
    private String title;
    private int id;
}
