package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
