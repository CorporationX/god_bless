package search.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.net.URL;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"title", "content"})
public class WebPage {
    @NonNull
    private final URL url;
    @NonNull
    private String title;
    @NonNull
    private String content;
}
