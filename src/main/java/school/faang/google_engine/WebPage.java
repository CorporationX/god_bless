package school.faang.google_engine;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WebPage {

    private String URL;
    private String title;
    private String content;
}
