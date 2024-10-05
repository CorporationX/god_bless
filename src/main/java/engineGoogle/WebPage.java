package engineGoogle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class WebPage {
    String url;
    String title;
    String content;

    public WebPage(String url, String title, String content) {

        if (url.isEmpty() && url.isBlank()) {
            throw new IllegalArgumentException("Нет URL веб-страницы");
        }

        this.url = url;
        this.title = title;
        this.content = content;
    }
}

//    public void checkExp(String url, String title, String content) {
//        if (url.isEmpty() && url.isBlank()) {
//            throw new IllegalArgumentException("Нет URL веб-страницы");
//        } else if (title.isEmpty() && title.isBlank(Нет)) {
//            throw new IllegalArgumentException("");
//        } else if (content.isEmpty() && content.isBlank()) {
//            throw new IllegalArgumentException("");
//        }





