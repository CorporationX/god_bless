package school.faang.HashMap4;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

    public WebPage(String url) {
        this.url = url;
    }
}
