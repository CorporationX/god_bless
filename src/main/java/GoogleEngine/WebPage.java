package GoogleEngine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WebPage {
    private final String url;
    private final String title;
    private final String content;
}
