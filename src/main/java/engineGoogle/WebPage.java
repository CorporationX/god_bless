package engineGoogle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {

        if (url.isEmpty() && url.isBlank()) {
            throw new IllegalArgumentException("Нет URL веб-страницы");
        }

        this.url = url;
        this.title = title;
        this.content = content;
    }
}






