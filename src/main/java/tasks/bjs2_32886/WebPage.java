package tasks.bjs2_32886;

import java.util.regex.Pattern;
import lombok.Data;

@Data
public class WebPage {
    private String url;
    private String title;
    private String content;

    private final String REGEX_PROTOCOL = "(https?|ftp)://";
    private final String REGEX_SUBDOMAIN = "(www\\.)?";
    private final String REGEX_DOMAIN = "([a-zA-Z0-9.-]+)\\.";
    private final String REGEX_TOP_LEVEL_DOMAIN = "[a-zA-Z]{2,6}";
    private final String REGEX_PATH = "(/[-a-zA-Z0-9@:%_+.~#?&/=]*)*$";
    private final Pattern REGEX_PATTERN = Pattern.compile(String.format(
        "^%s%s%s%s%s$",REGEX_PROTOCOL,REGEX_SUBDOMAIN,REGEX_DOMAIN,REGEX_TOP_LEVEL_DOMAIN,REGEX_PATH
    ));

    public WebPage(String url, String title, String content) {
        if (!REGEX_PATTERN.matcher(url).matches()) {
            throw new IllegalArgumentException("Некорректный URL: " + url);
        }

        if (title.isBlank()) {
            throw new IllegalArgumentException("Заголовок страницы не может быть пустым");
        }

        if (content.isBlank()) {
            throw new IllegalArgumentException("Содержание страницы не может быть пустым");
        }

        this.url = url;
        this.title = title;
        this.content = content;
    }
}
