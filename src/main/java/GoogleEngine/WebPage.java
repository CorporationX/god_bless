package GoogleEngine;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public List<String> getKeywords(WebPage webPage) {
        List<String> keywords = new ArrayList<>();
        String tempKeywords = webPage.getContent();
        String[] tempArrayKeywords = tempKeywords.split(" ");

        keywords.addAll(Arrays.asList(tempArrayKeywords));
        return keywords;
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
