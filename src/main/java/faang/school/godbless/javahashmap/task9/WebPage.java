package faang.school.godbless.javahashmap.task9;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"url"})
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
