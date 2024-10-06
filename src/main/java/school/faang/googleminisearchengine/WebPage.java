package school.faang.googleminisearchengine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {

    String url;
    String title;
    String content;
}
