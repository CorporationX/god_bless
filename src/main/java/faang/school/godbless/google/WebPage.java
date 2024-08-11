package faang.school.godbless.google;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Title: " + title + ", URL: " + url;
    }
}


