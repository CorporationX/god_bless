package faang.school.godbless.GoogleSearch;

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
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
