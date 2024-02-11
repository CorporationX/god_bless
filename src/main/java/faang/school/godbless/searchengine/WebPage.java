package faang.school.godbless.searchengine;

public class WebPage {
    private final String url;
    private final String title;
    private final String content;

    public WebPage(String url, String title, String content) {
        if (url.matches(REGEX_FOR_URL)) {
            this.url = url;
        } else {
            this.url = "https://regex101.com";
        }
        this.title = title;
        this.content = content;
    }

    private static final String REGEX_FOR_URL = "^(https?|ftp|file):\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]";

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
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
