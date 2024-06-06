package faang.school.godbless.googleEngine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WebPage {

    private String url;
    private String title;
    private String content;
}
