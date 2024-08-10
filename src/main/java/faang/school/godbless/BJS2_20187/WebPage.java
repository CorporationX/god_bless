package faang.school.godbless.BJS2_20187;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WebPage {
    @Getter
    private String url;
    private String title;
    @Getter
    @ToString.Exclude
    private String content;
}
