package school.faang.minisearchengine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(url, webPage.url) && Objects.equals(title, webPage.title) && Objects.equals(content, webPage.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, title, content);
    }
}
