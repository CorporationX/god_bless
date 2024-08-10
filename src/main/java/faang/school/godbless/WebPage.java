package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "url: " + url + ", title: " + title + ", content: " + content;
    }
}
