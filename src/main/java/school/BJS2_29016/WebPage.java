package school.BJS2_29016;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class WebPage {

    private String url;
    private String title;
    private List<String> content;

    public WebPage(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}