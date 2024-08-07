package faang.school.godbless.googles_mini_search_engine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;
}
