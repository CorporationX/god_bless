package faang.school.godbless.BJS2_20244;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class WebPage {
    private String url;
    private String title;
    private String content;
}
