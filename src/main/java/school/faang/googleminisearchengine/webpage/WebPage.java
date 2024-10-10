package school.faang.googleminisearchengine.webpage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {

    String url;
    String title;
    String content;
}
