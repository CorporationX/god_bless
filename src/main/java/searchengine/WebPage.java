package searchengine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WebPage {
    @Getter
    private String url;
    private String title;
    @Getter
    private String content;
}
