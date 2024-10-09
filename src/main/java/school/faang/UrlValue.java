package school.faang;

import lombok.Data;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

@Data
public class UrlValue{
    private String word;
    private WebPage webPage;

    public UrlValue(String word, WebPage webPage) {
        this.word = word;
        this.webPage = webPage;
    }
}
