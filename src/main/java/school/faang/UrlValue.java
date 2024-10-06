package school.faang;

import java.util.LinkedList;
import java.util.function.UnaryOperator;

public class UrlValue extends LinkedList<UrlValue> {
    private String word;
    private WebPage webPage;

    public UrlValue(String word, WebPage webPage) {
        this.word = word;
        this.webPage = webPage;
    }

    public String getWord() {
        return word;
    }

    public WebPage getWebPage() {
        return webPage;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }

    @Override
    public void replaceAll(UnaryOperator<UrlValue> operator) {
        super.replaceAll(operator);


    }

}
