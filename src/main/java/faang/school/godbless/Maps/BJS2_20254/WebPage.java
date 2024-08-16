package faang.school.godbless.Maps.BJS2_20254;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
@ToString
public class WebPage {

    public String url;
    private String title;
    private String content = "Some text with question mark ? Good bye!!";

    public WebPage(String url) {
        this.url = url;
    }
}
