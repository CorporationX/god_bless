package faang.school.godbless.BJS2_20195;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;
}
