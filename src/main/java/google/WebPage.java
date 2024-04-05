package google;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
