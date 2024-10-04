package googleSearchEngine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
