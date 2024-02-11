package faang.school.godbless.GoogleSearchEngine2070;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }
}