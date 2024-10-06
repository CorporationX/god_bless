package school.faang;

public class WebPage {
    private String url;
    private String titlel;
    private String content;

    public WebPage(String url, String titlel, String content) {
        this.url = url;
        this.titlel = titlel;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitlel() {
        return titlel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitlel(String titlel) {
        this.titlel = titlel;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
