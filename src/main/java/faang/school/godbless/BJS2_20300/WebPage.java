package faang.school.godbless.BJS2_20300;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
