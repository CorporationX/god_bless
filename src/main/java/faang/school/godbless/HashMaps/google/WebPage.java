package faang.school.godbless.HashMaps.google;

import java.util.Objects;

public record WebPage(String url, String title, String content) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebPage webPage = (WebPage) o;

        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    public WebPage(String url) {
        this(url, "", "");
    }
}
