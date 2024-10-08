package school.BJS2_29016;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WebPage {

    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "WebPage{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}