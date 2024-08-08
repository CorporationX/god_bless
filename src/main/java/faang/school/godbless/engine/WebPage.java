package faang.school.godbless.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URL;

@AllArgsConstructor
public class WebPage {
    @Getter
    private URL url;
    private String title;
    @Getter
    private String content;
}
