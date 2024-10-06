package school.faang.search.engine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class WebPage {
    private static final int MAX_LIMIT = 5;

    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        String partOfContent = Stream.of(content.split("\\PL+"))
                .limit(MAX_LIMIT)
                .collect(Collectors.joining(" "));
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + partOfContent + '\'' +
                '}';
    }
}
