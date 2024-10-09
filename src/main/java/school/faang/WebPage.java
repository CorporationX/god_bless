package school.faang;

import lombok.Data;

@Data
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String titlel, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }
}
