package faang.school.godbless.r_edzie.google;

import lombok.Data;

@Data
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
