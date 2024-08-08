package faang.school.godbless.SearchMiniGoogle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class WebPage {
    private String title;
    private String url;
    private String content;
}
