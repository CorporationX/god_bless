package faang.school.godbless.javahashmap.searchengine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class WebPage {
    @Getter
    private String url;
    private String title;
    @Getter
    private String content;
}
