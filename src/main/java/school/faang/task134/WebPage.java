package school.faang.task134;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class WebPage {
    @Getter
    private String url;
    private String title;
    @Getter
    private String content;
}
