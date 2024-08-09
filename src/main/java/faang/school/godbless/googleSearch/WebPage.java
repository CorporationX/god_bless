package faang.school.godbless.googleSearch;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public String toString() {
        return url;
    }
}
