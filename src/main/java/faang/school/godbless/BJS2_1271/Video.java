package faang.school.godbless.BJS2_1271;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Video {
    private String url;

    @Override
    public String toString() {
        return "Video url = " + url;
    }
}