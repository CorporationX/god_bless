package school.faang.mini_engine_google;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebPage {
    private String url;
    private String title;
    private String context;
}
