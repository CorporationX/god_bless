package faang.school.godbless.search_engine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals( url, webPage.url ) && Objects.equals( title, webPage.title ) && Objects.equals( content, webPage.content );
    }

    @Override
    public int hashCode() {
        return Objects.hash( url, title, content );
    }
}
