package faang.school.godbless.googles_mini_search_engine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        if (url == null || title == null || content == null) {
            throw new IllegalArgumentException("url, title, and content cannot be null");
        }
        if (url.isEmpty() || title.isEmpty() || content.isEmpty()) {
            throw new IllegalArgumentException("url, title, and content cannot be empty");
        }
        this.url = url;
        this.title = title;
        this.content = content;
    }
}
