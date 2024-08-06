package faang.school.godbless.google;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "URL: " + url + " " + "TITLE: " + title;
    }
}
