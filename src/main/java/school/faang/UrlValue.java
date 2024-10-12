package school.faang;

import lombok.Data;
@Data
public class UrlValue{
    private String word;
    private WebPage webPage;

    public UrlValue(String word, WebPage webPage) {
        this.word = word;
        this.webPage = webPage;
    }
}
