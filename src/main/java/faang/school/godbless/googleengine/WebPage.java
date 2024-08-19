package faang.school.godbless.googleengine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class WebPage {

    private String url;
    private String title;
    private String content;

}
