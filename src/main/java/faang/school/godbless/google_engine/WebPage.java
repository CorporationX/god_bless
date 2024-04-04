package faang.school.godbless.google_engine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
