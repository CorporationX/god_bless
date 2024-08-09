package faang.school.godbless.search_engine;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebPage {
    private final String url;
    private final String title;
    private final String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }
}