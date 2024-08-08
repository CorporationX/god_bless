package BJS2_20213;

import lombok.ToString;

import java.util.Objects;

@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(getUrl(), webPage.getUrl()) && Objects.equals(getTitle(), webPage.getTitle()) && Objects.equals(getContent(), webPage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getTitle(), getContent());
    }
}
