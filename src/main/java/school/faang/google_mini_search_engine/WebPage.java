package school.faang.google_mini_search_engine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
