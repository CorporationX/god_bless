package faang.school.godbless.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
public class WebPage {
    @NonNull
    private String url;
    @NonNull
    private String title;
    @NonNull
    private String content;
}
