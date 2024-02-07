package src.main.java.faang.school.godbless;

public class WebPage {


    String url;
    String title;
    static String content;

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

    public static String getContent() {
        return content;
    }
}
