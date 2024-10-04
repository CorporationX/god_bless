package school.faang.searchengine.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}