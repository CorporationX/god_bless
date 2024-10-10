package tasks.bjs2_32886;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    public static WebPage createValidated(String url, String title, String content) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Заголовок страницы не может быть пустым");
        }

        if (content.isBlank()) {
            throw new IllegalArgumentException("Содержание страницы не может быть пустым");
        }

        String regexProtocol = "(https?|ftp)://";
        String regexSubDomain = "(www\\.)?";
        String regexDomain = "([a-zA-Z0-9.-]+)\\.";
        String regexTopLevelDomain = "[a-zA-Z]{2,6}";
        String regexPath = "(/[-a-zA-Z0-9@:%_+.~#?&/=]*)*$";
        String regexUrl = String.format(
            "^%s%s%s%s%s$",regexProtocol,regexSubDomain,regexDomain,regexTopLevelDomain,regexPath
        );
        Pattern pattern = Pattern.compile(regexUrl);
        Matcher matcher = pattern.matcher(url);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Некорректный URL: " + url);
        }

        return new WebPage(url, title, content);
    }
}
