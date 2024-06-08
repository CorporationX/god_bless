package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class WebPage {
    private final String url;
    private final String title;
    private final String content;
}
