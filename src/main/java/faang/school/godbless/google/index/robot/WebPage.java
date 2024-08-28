package faang.school.godbless.google.index.robot;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class WebPage {

    private String url;
    private String title;
    private String content;
}
