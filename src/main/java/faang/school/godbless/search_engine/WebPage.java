package faang.school.godbless.search_engine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
