package school.faang.HashMaps.miniGoogleEngine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebPage {
    private String url;
    private String title;
    private String content;
}
