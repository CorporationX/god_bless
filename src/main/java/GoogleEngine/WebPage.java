package GoogleEngine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class WebPage {
    private final String url;
    private final String title;
    private final String content;
}
