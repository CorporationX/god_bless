package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
