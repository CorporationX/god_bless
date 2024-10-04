package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class WebPage {

    private final String url;
    private String title;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebPage webPage)) return false;
        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }
}
